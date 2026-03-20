package com.deh.lumen.checkin.di

import com.deh.lumen.checkin.usecase.GenerateQuestionsUseCase
import com.deh.lumen.checkin.usecase.GenerateReflectionUseCase
import com.deh.lumen.checkin.usecase.HasCheckedInUseCase
import com.deh.lumen.checkin.usecase.SafetyUseCase
import com.deh.lumen.checkin.usecase.SaveCheckInUseCase
import com.deh.lumen.core_data.repository.CheckInRepository
import com.deh.lumen.core_data.repository.UserRepository
import com.google.firebase.ai.GenerativeModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object CheckInModule {
    @Provides
    @ViewModelScoped
    fun provideHasCheckedInUseCase(
        checkInRepository: CheckInRepository
    ): HasCheckedInUseCase =
        HasCheckedInUseCase(checkInRepository)

    @Provides
    @ViewModelScoped
    fun provideSaveCheckInUseCase(
        checkInRepository: CheckInRepository,
        userRepository: UserRepository
    ): SaveCheckInUseCase =
        SaveCheckInUseCase(checkInRepository, userRepository)

    @Provides
    @ViewModelScoped
    fun provideGenerateQuestionsUseCase(
        checkInRepository: CheckInRepository,
        userRepository: UserRepository,
        model: GenerativeModel
    ): GenerateQuestionsUseCase =
        GenerateQuestionsUseCase(checkInRepository, userRepository, model)

    @Provides
    @ViewModelScoped
    fun provideGenerateReflectionUseCase(
        model: GenerativeModel
    ): GenerateReflectionUseCase =
        GenerateReflectionUseCase(model)

    @Provides
    @ViewModelScoped
    fun provideSafetyUseCase(
        model: GenerativeModel,
        checkInRepository: CheckInRepository
    ): SafetyUseCase =
        SafetyUseCase(model, checkInRepository)
}