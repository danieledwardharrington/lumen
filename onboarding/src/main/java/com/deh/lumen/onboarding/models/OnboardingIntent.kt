package com.deh.lumen.onboarding.models

import com.deh.lumen.onboarding.R

sealed class OnboardingIntent(
    val intentTitleRes: Int,
    val intentDescriptionRes: Int,
    val isSelected: Boolean = false
) {
    data class Awareness(
        val titleRes: Int = R.string.awareness_title,
        val descriptionRes: Int = R.string.awareness_description
    ) : OnboardingIntent(titleRes, descriptionRes)

    data class Track(
        val titleRes: Int = R.string.track_title,
        val descriptionRes: Int = R.string.track_description
    ) : OnboardingIntent(titleRes, descriptionRes)

    data class Reflection(
        val titleRes: Int = R.string.reflection_title,
        val descriptionRes: Int = R.string.reflection_description
    ) : OnboardingIntent(titleRes, descriptionRes)

    data class Therapy(
        val titleRes: Int = R.string.therapy_title,
        val descriptionRes: Int = R.string.therapy_description
    ) : OnboardingIntent(titleRes, descriptionRes)
}