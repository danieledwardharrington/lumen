package com.deh.lumen.checkin.usecase

import com.deh.lumen.core_data.models.QuestionAnswerPair
import com.deh.lumen.core_data.entity.enum.MoodLevel
import com.google.firebase.ai.GenerativeModel
import javax.inject.Inject

class GenerateReflectionUseCase @Inject constructor(
    private val aiModel: GenerativeModel
) {

    /**
     * Generates a single closing reflection to display on
     * the check-in completion screen.
     *
     * The reflection mirrors back what the user shared in
     * a warm and human way. It does not interpret, diagnose,
     * advise, or suggest next steps — it only reflects.
     *
     * Input is the mood level and both question-answer pairs
     * from the current session. Returns a Result wrapping
     * a plain string, or a failure if the AI call fails.
     */
    suspend operator fun invoke(
        moodLevel: MoodLevel,
        answers: List<QuestionAnswerPair>
    ): Result<String> {
        return try {
            val prompt = buildPrompt(moodLevel, answers)
            val response = aiModel.generateContent(prompt)
            val reflection = response.text?.trim()
                ?: return Result.failure(
                    IllegalStateException("Empty response from model")
                )
            Result.success(reflection)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun buildPrompt(
        moodLevel: MoodLevel,
        answers: List<QuestionAnswerPair>
    ): String {
        val answersText = answers.joinToString("\n") { pair ->
            "Q: ${pair.question}\nA: ${pair.answer}"
        }

        return """
            You are a warm, thoughtful assistant inside a daily mental health check-in app called Lumen.
            
            A user has just completed their check-in. Your task is to write a single closing reflection
            that will be shown to them on the completion screen.
            
            THEIR CHECK-IN:
            Mood: ${moodLevel.name}
            
            $answersText
            
            RULES:
            - Write one to two sentences only — this is a brief, warm acknowledgment, not an essay
            - Mirror back the emotional content of what they shared in your own words
            - Use warm, human language — not clinical, not cheerful, not performatively empathetic
            - Do NOT interpret, diagnose, advise, or suggest anything they should do
            - Do NOT use hollow affirmations like "That's so brave" or "Thank you for sharing"
            - Do NOT start with "I" — vary your sentence openings
            - Adjust tone to match the mood: quieter and more careful for lower moods, lighter for higher moods
            
            Respond with ONLY the reflection text, nothing else.
            Example format: What you shared sounds genuinely heavy. You don't have to carry it alone.
        """.trimIndent()
    }
}