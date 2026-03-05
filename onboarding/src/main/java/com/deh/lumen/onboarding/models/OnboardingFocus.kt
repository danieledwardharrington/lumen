package com.deh.lumen.onboarding.models

import com.deh.lumen.onboarding.R

sealed class OnboardingFocus(
    val focusRes: Int,
    val focusEmoji: String
) {
    data class Work(
        val focus: Int = R.string.focus_work,
        val emoji: String = "\uD83D\uDCBC"
    ) : OnboardingFocus(focus, emoji)

    data class Relationships(
        val focus: Int = R.string.focus_relationships,
        val emoji: String = "\uD83E\uDEF6"
    ) : OnboardingFocus(focus, emoji)

    data class Sleep(
        val focus: Int = R.string.focus_sleep,
        val emoji: String = "\uD83D\uDE34"
    ) : OnboardingFocus(focus, emoji)

    data class Health(
        val focus: Int = R.string.focus_health,
        val emoji: String = "\uD83C\uDFC3"
    ) : OnboardingFocus(focus, emoji)

    data class Social(
        val focus: Int = R.string.focus_work,
        val emoji: String = "\uD83D\uDC65"
    ) : OnboardingFocus(focus, emoji)

    data class Family(
        val focus: Int = R.string.focus_family,
        val emoji: String = "\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67"
    ) : OnboardingFocus(focus, emoji)

    data class Finances(
        val focus: Int = R.string.focus_finances,
        val emoji: String = "\uD83D\uDCB0"
    ) : OnboardingFocus(focus, emoji)

    data class Growth(
        val focus: Int = R.string.focus_growth,
        val emoji: String = "\uD83C\uDF31"
    ) : OnboardingFocus(focus, emoji)
}