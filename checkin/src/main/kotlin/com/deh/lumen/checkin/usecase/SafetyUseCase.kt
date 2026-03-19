package com.deh.lumen.checkin.usecase

import com.deh.lumen.core_data.entity.enum.SafetyConfidence
import com.deh.lumen.core_data.models.SafetyStatus
import com.deh.lumen.core_data.models.QuestionAnswerPair
import com.deh.lumen.core_data.repository.CheckInRepository
import com.google.firebase.ai.GenerativeModel
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.jsonPrimitive
import javax.inject.Inject

class SafetyUseCase @Inject constructor(
    private val aiModel: GenerativeModel,
    private val checkInRepository: CheckInRepository
) {
    suspend operator fun invoke(
        entryId: String,
        answers: List<QuestionAnswerPair>
    ): Result<SafetyStatus> {
        return try {
            val answerText = answers.joinToString("\n") { it.answer }
            val prompt = buildPrompt(answerText)
            val response = aiModel.generateContent(prompt)
            val responseText = response.text?.trim()
                ?: return Result.failure(
                    IllegalStateException("Empty response from model")
                )

            val safetyStatus = parseResponse(responseText)
            checkInRepository.updateSafetyFlag(entryId, safetyStatus)
            Result.success(safetyStatus)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun buildPrompt(answerText: String): String {
        return """
            You are a safety classification system. Your only task is to 
            analyze the following text for signs of acute distress, suicidal 
            ideation, self-harm language, or crisis indicators.
            
            TEXT TO CLASSIFY:
            $answerText
            
            RULES:
            - Do NOT generate any response text, advice, or resources
            - Do NOT engage with the content in any way
            - Classify only — return a JSON object and nothing else
            - flagged must be true or false
            - confidence must be one of: "low", "medium", "high"
            - If there are no indicators of distress, return flagged: false
            - Use confidence "clear" for no distress at all
            - Use confidence "low" for mild or ambiguous language
            - Use confidence "medium" for clear but non-acute distress language
            - Use confidence "high" for explicit crisis indicators or 
              direct expressions of suicidal ideation or self-harm intent
            
            Respond with ONLY this JSON, no preamble, no explanation:
            {
              "flagged": true or false,
              "confidence": "clear" or "low" or "medium" or "high"
            }
        """.trimIndent()
    }

    private fun parseResponse(responseText: String): SafetyStatus {
        val clean = responseText
            .replace("```json", "")
            .replace("```", "")
            .trim()
        val parsed = Json.decodeFromString<Map<String, JsonElement>>(clean)
        return SafetyStatus(
            flagged    = parsed["flagged"]?.jsonPrimitive?.boolean ?: false,
            confidence = SafetyConfidence.fromString(
                parsed["confidence"]?.jsonPrimitive?.content ?: "low"
            )
        )
    }
}