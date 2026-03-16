package com.deh.lumen.checkin.usecase

import com.deh.lumen.core_data.entity.CheckInEntity
import com.deh.lumen.core_data.entity.UserEntity
import com.deh.lumen.core_data.entity.enum.MoodLevel
import com.deh.lumen.core_data.repository.CheckInRepository
import com.deh.lumen.core_data.repository.UserRepository
import com.google.firebase.ai.GenerativeModel
import kotlinx.coroutines.flow.first
import kotlinx.serialization.json.Json
import timber.log.Timber
import javax.inject.Inject

class GenerateQuestionsUseCase @Inject constructor(
    private val checkInRepository: CheckInRepository,
    private val userRepository: UserRepository,
    private val aiModel: GenerativeModel
) {
    suspend operator fun invoke(moodLevel: MoodLevel): Result<Pair<String, String>> {
        return try {
            val user = userRepository.getUser()
                ?: return Result.failure(IllegalStateException("User not found"))

            val recentEntries = checkInRepository
                .observeRecentCheckIns(limit = 3)
                .first()

            val prompt =
                buildPrompt(moodLevel = moodLevel, user = user, recentEntries = recentEntries)
            val response = aiModel.generateContent(prompt)
            val responseText = response.text
                ?: return Result.failure(IllegalStateException("Empty response from AI model"))

            val questions = parseQuestions(responseText)
            Result.success(questions)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun buildPrompt(
        moodLevel: MoodLevel,
        user: UserEntity,
        recentEntries: List<CheckInEntity>
    ): String {
        val recentContext = if (recentEntries.isEmpty()) {
            Timber.d("User's first entry")
        } else {
            recentEntries.joinToString("\n") { entry ->
                "- ${entry.date}: Mood ${entry.moodScore}/5. " +
                        entry.questionAnswerPairs.joinToString(" | ") { pair ->
                            "Q: ${pair.question} A: ${pair.answer}"
                        }

            }
        }

        val recentQuestions = recentEntries
            .flatMap { it.questionAnswerPairs }
            .map { it.question }
            .distinct()
            .joinToString("\n") { "- $it" }

        return """
            You are a warm, thoughtful assistant inside a daily mental health check-in app called Lumen.
            
            Your task is to generate exactly two follow-up questions for a user who has just selected their mood.
            
            USER CONTEXT:
            - Intention: ${user.intention.name}
            - Focus areas: ${user.focusAreas.joinToString(", ") { it.name }}
            - Selected mood today: ${moodLevel.name}
            
            RECENT CHECK-IN HISTORY (last 3 entries):
            $recentContext
            
            QUESTIONS ASKED RECENTLY (do not repeat these):
            $recentQuestions
            
            RULES:
            - Generate exactly two questions, nothing more
            - Each question must be one sentence, warm and conversational in tone
            - Questions should be open-ended and invite reflection, not yes/no answers
            - Adjust the emotional register to match the mood: gentler and more supportive for lower moods, curious and exploratory for higher moods
            - Do not reference previous entries directly — use them only to inform tone and avoid repetition
            - Do not ask about the same topic twice across both questions
            - Do not diagnose, advise, or suggest anything clinical
            
            Respond with ONLY a JSON object in this exact format, with no preamble or explanation:
            {
              "question_one": "Your first question here",
              "question_two": "Your second question here"
            }
        """.trimIndent()
    }

    private fun parseQuestions(responseText: String): Pair<String, String> {
        val clean = responseText
            .replace("```json", "")
            .replace("```", "")
            .trim()
        val parsed = Json.decodeFromString<Map<String, String>>(clean)
        return Pair(
            parsed["question_one"]
                ?: error("Missing question_one in model response"),
            parsed["question_two"]
                ?: error("Missing question_two in model response")
        )
    }
}