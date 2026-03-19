package com.deh.lumen.profile.usecase

import androidx.room.withTransaction
import com.deh.lumen.core_data.database.LumenDatabase
import com.deh.lumen.core_data.repository.CheckInRepository
import com.deh.lumen.core_data.repository.UserRepository
import javax.inject.Inject

class DeleteAllDataUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val checkInRepository: CheckInRepository,
    private val database: LumenDatabase
) {
    suspend operator fun invoke() {
        database.withTransaction {
            userRepository.deleteUser()
            checkInRepository.deleteAllCheckIns()
        }
    }
}