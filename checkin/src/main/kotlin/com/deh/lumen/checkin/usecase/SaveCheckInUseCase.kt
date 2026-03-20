package com.deh.lumen.checkin.usecase

import com.deh.lumen.checkin.models.CheckInEntry
import com.deh.lumen.core_data.entity.CheckInEntity
import com.deh.lumen.core_data.repository.CheckInRepository
import com.deh.lumen.core_data.repository.UserRepository
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import timber.log.Timber
import javax.inject.Inject
import kotlin.time.Clock
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class SaveCheckInUseCase @Inject constructor(
    private val checkInRepository: CheckInRepository,
    private val userRepository: UserRepository
) {
    @OptIn(ExperimentalUuidApi::class)
    suspend operator fun invoke(entry: CheckInEntry): Result<CheckInEntity> {
        require(entry.questionsAnswers.size == 2) {
            Timber.e("There must be two questions")
        }

        require(entry.questionsAnswers.all { it.answer.isNotEmpty()} ) {
            Timber.e("All questions must have an answer")
        }

        require(entry.moodLevel != null) {
            Timber.e("Mood must be selected")
        }

        require(entry.aiReflection.isNullOrEmpty().not()) {
            Timber.e("Must have AI reflection")
        }

        return checkInRepository.saveCheckIn(
            CheckInEntity(
                id = Uuid.random().toString(),
                date = Clock
                    .System
                    .now()
                    .toLocalDateTime(TimeZone.currentSystemDefault())
                    .date,
                moodScore = entry.moodLevel.score,
                moodLevel = entry.moodLevel,
                questionAnswerPairs = entry.questionsAnswers,
                editedAnswerPairs = entry.editedQuestionsAnswers,
                aiReflection = entry.aiReflection,
                submittedAt = Clock
                    .System
                    .now()
                    .toLocalDateTime(TimeZone.currentSystemDefault())
            )
        ).onSuccess { updateStreak() }
    }

    private suspend fun updateStreak() {
        val user = userRepository.getUser()
        if (user != null) {
            val dates = checkInRepository
                .getAllCheckInsForExport()
                .map { it.date }
                .sortedDescending()

            if (dates.isEmpty()) return

            var streak = 1
            for (i in dates.indices) {
                val diff = dates[i].toEpochDays() - dates[i + 1].toEpochDays()
                if (diff == 1L) streak++ else break
            }

            val today = Clock.System.now()
            val activeStreak = if (dates.first() == today) streak else 0

            val newBest = maxOf(user.bestStreak, activeStreak)

            userRepository.updateUser {
                copy(
                    currentStreak = activeStreak,
                    bestStreak = newBest
                )
            }
        }
    }
}