package com.deh.lumen.core_data.models

import com.deh.lumen.core_data.entity.UserEntity
import com.deh.lumen.core_data.entity.enum.FocusArea
import com.deh.lumen.core_data.entity.enum.UserIntention
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime

data class UserProfile(
    val displayName: String,
    val memberSince: LocalDate,
    val reminderTime: LocalTime,
    val focusAreas: List<FocusArea>,
    val notificationsEnabled: Boolean,
    val appLockEnabled: Boolean,
    val cloudEnabled: Boolean,
    val monitoringEnabled: Boolean,
    val insightDay: InsightDay,
    val totalCheckInCount: Int,
    val currentStreak: Int,
    val bestStreak: Int,
    val averageMoodScore: Float
)