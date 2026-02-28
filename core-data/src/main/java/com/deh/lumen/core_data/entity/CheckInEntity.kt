package com.deh.lumen.core_data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.deh.lumen.core_data.CoreDataConstants
import com.deh.lumen.core_data.QuestionAnswerPair
import com.deh.lumen.core_data.entity.enum.MoodLevel
import com.deh.lumen.core_data.entity.enum.SafetyFlag
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
@Entity(
    tableName = CoreDataConstants.CHECK_IN_TABLE_NAME,
    indices = [
        Index(value = ["date"], unique = true)  // enforces one entry per day at the database level
    ]
)
data class CheckInEntity(
    @PrimaryKey
    val id: String = Uuid.Companion.random().toString(),
    val date: LocalDate,
    val moodScore: Int,
    val moodLevel: MoodLevel,
    val questionAnswerPairs: List<QuestionAnswerPair>,
    val editedAnswerPairs: List<QuestionAnswerPair>? = null,
    val aiReflection: String,
    val safetyFlag: SafetyFlag? = null,
    val submittedAt: LocalDateTime,
    val editedAt: LocalDateTime? = null
)
