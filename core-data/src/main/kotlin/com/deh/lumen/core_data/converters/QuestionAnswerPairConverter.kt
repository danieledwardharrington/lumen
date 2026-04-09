package com.deh.lumen.core_data.converters

import androidx.room.TypeConverter
import com.deh.lumen.core_data.models.QuestionAnswerPair
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class QuestionAnswerPairConverter {
    @TypeConverter
    fun fromList(value: List<QuestionAnswerPair>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun toList(value: String): List<QuestionAnswerPair> {
        return try {
            Json.decodeFromString(value)
        } catch (e: Exception) {
            emptyList()
        }
    }
    
    @TypeConverter
    fun fromNullableList(value: List<QuestionAnswerPair>?): String? {
        return value?.let { Json.encodeToString(it) }
    }

    @TypeConverter
    fun toNullableList(value: String?): List<QuestionAnswerPair>? {
        return value?.let {
            try {
                Json.decodeFromString(it)
            } catch (e: Exception) {
                null
            }
        }
    }
}
