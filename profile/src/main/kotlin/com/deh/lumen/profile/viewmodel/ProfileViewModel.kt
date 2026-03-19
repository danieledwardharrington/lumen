package com.deh.lumen.profile.viewmodel

import androidx.lifecycle.ViewModel
import com.deh.lumen.core_data.repository.CheckInRepository
import com.deh.lumen.core_data.repository.UserRepository
import com.deh.lumen.profile.models.ProfileState
import com.deh.lumen.profile.usecase.DeleteAllDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val checkInRepository: CheckInRepository,
    private val deleteAllDataUseCase: DeleteAllDataUseCase
): ViewModel() {

}