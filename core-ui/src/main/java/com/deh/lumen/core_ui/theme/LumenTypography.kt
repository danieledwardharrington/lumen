package com.deh.lumen.core_ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// ─────────────────────────────────────────────────────────────
// Font Families
// ─────────────────────────────────────────────────────────────
//
// Lumen uses two typefaces:
//
// Fraunces — an optical-size serif with a distinctive italic.
// Used for all display text, headings, greetings, questions,
// and any copy that should feel warm, editorial, or personal.
// Downloaded from Google Fonts and placed in res/font/.
//
// DM Sans — a clean geometric sans-serif at light weight.
// Used for all UI text: labels, sublabels, body copy, buttons,
// settings rows, nav bar labels, character counters.
// Downloaded from Google Fonts and placed in res/font/.
//
// Font files needed in res/font/:
//   fraunces_light.ttf           (weight 300, normal)
//   fraunces_light_italic.ttf    (weight 300, italic)
//   fraunces_regular.ttf         (weight 400, normal)
//   fraunces_regular_italic.ttf  (weight 400, italic)
//   fraunces_medium.ttf          (weight 500, normal)
//   dm_sans_light.ttf            (weight 300, normal)
//   dm_sans_regular.ttf          (weight 400, normal)
//   dm_sans_medium.ttf           (weight 500, normal)
// ─────────────────────────────────────────────────────────────

val FrauncesFamily = FontFamily(
    Font(R.font.fraunces_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.fraunces_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.fraunces_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.fraunces_regular_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.fraunces_medium, FontWeight.Medium, FontStyle.Normal),
)

val DmSansFamily = FontFamily(
    Font(R.font.dm_sans_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.dm_sans_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.dm_sans_medium, FontWeight.Medium, FontStyle.Normal),
)

// ─────────────────────────────────────────────────────────────
// Lumen Text Styles
//
// Named by role, not by size, so usage is self-documenting.
// All sizes are in sp. Line heights are explicit to match
// the tight, refined spacing seen in the mockups.
// ─────────────────────────────────────────────────────────────

object LumenTextStyle {

    // ── Display ─────────────────────────────────────────────
    // Large Fraunces headings. Screen titles, greetings,
    // onboarding headlines. Always light weight.

    /**
     * The app wordmark / logo treatment.
     * "LUMEN" in spaced uppercase Fraunces light.
     * Used in the check-in header and onboarding welcome.
     */
    val Wordmark = TextStyle(
        fontFamily = FrauncesFamily,
        fontWeight = FontWeight.Light,
        fontSize  = 16.sp,
        letterSpacing = 0.15.sp * 15,   // ~0.15em
        color         = LumenColor.TextMuted
    )

    /**
     * Large screen greeting.
     * "Good evening, how are you holding up?"
     * 28sp Fraunces light. Italic emphasis applied inline.
     */
    val Greeting = TextStyle(
        fontFamily  = FrauncesFamily,
        fontWeight  = FontWeight.Light,
        fontSize    = 28.sp,
        lineHeight  = 34.sp,
        color       = LumenColor.TextPrimary
    )

    /**
     * Screen title. "Your Timeline", "Weekly Insight", "Profile".
     * 26sp Fraunces light.
     */
    val ScreenTitle = TextStyle(
        fontFamily = FrauncesFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 26.sp,
        lineHeight = 31.sp,
        color      = LumenColor.TextPrimary
    )

    /**
     * Onboarding headline. Large, italic, two-line.
     * "What brings you to Lumen?"
     * 24sp Fraunces light.
     */
    val OnboardingHeadline = TextStyle(
        fontFamily = FrauncesFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 24.sp,
        lineHeight = 30.sp,             // 1.25x
        color      = LumenColor.TextPrimary
    )

    /**
     * Insight card headline.
     * "You started strong, then work stress crept in."
     * 20sp Fraunces light italic.
     */
    val InsightHeadline = TextStyle(
        fontFamily  = FrauncesFamily,
        fontWeight  = FontWeight.Light,
        fontStyle   = FontStyle.Italic,
        fontSize    = 20.sp,
        lineHeight  = 28.sp,            // 1.4x
        color       = LumenColor.TextPrimary
    )

    /**
     * Follow-up question text inside check-in cards.
     * "What's been weighing on you most today?"
     * 15sp Fraunces light italic.
     */
    val Question = TextStyle(
        fontFamily  = FrauncesFamily,
        fontWeight  = FontWeight.Light,
        fontStyle   = FontStyle.Italic,
        fontSize    = 15.sp,
        lineHeight  = 22.5.sp,          // 1.5x
        color       = LumenColor.TextPrimary
    )

    /**
     * Onboarding welcome tagline.
     * "A quiet moment, just for you."
     * 22sp Fraunces light italic, centered.
     */
    val WelcomeTagline = TextStyle(
        fontFamily  = FrauncesFamily,
        fontWeight  = FontWeight.Light,
        fontStyle   = FontStyle.Italic,
        fontSize    = 22.sp,
        lineHeight  = 29.7.sp,          // 1.35x
        textAlign   = TextAlign.Center,
        color       = LumenColor.TextPrimary
    )

    /**
     * First check-in bridge headline.
     * "Let's do your first check-in together."
     * 22sp Fraunces light italic, centered.
     */
    val BridgeHeadline = TextStyle(
        fontFamily  = FrauncesFamily,
        fontWeight  = FontWeight.Light,
        fontStyle   = FontStyle.Italic,
        fontSize    = 22.sp,
        lineHeight  = 28.6.sp,          // 1.3x
        textAlign   = TextAlign.Center,
        color       = LumenColor.TextPrimary
    )

    // ── Large Numbers (Fraunces) ─────────────────────────────
    // Used in stat cards and streak display.

    /** Streak count — 28sp Fraunces light, gold. */
    val StreakNumber = TextStyle(
        fontFamily = FrauncesFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 28.sp,
        lineHeight = 28.sp,
        color      = LumenColor.AccentGold
    )

    /** Stat card number — 26sp Fraunces light. Color applied per usage. */
    val StatNumber = TextStyle(
        fontFamily = FrauncesFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 26.sp,
        lineHeight = 26.sp,
        color      = LumenColor.TextPrimary
    )

    /** Entry date number in timeline rows — 16sp Fraunces light. */
    val EntryDateNumber = TextStyle(
        fontFamily = FrauncesFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 16.sp,
        lineHeight = 16.sp,
        color      = LumenColor.TextPrimary
    )

    /** Tip card title — 17sp Fraunces light. */
    val TipTitle = TextStyle(
        fontFamily = FrauncesFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 17.sp,
        lineHeight = 22.1.sp,           // 1.3x
        color      = LumenColor.TextPrimary
    )

    /** User display name in profile card — 18sp Fraunces light. */
    val UserName = TextStyle(
        fontFamily = FrauncesFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 18.sp,
        lineHeight = 21.6.sp,
        color      = LumenColor.TextPrimary
    )

    // ── Body (DM Sans) ───────────────────────────────────────

    /**
     * Primary body text. Insight card body, privacy screen descriptions,
     * onboarding body copy. 13sp DM Sans light.
     */
    val Body = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 13.sp,
        lineHeight = 21.45.sp,          // 1.65x
        color      = LumenColor.TextMuted
    )

    /**
     * Settings row primary label. "Daily Reminder", "App Lock".
     * 13sp DM Sans regular.
     */
    val SettingsLabel = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize   = 13.sp,
        lineHeight = 18.sp,
        color      = LumenColor.TextPrimary
    )

    /**
     * Settings row sublabel. "When would you like to check in?"
     * 11sp DM Sans light.
     */
    val SettingsSublabel = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 11.sp,
        lineHeight = 15.sp,
        color      = LumenColor.TextMuted
    )

    /**
     * Settings row trailing value. "9:00 PM", "Sunday", "300".
     * 12sp DM Sans light.
     */
    val SettingsValue = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 12.sp,
        lineHeight = 16.sp,
        color      = LumenColor.TextMuted
    )

    /**
     * Screen subtitle. "February 2026", "Your account & preferences".
     * 12sp DM Sans light.
     */
    val ScreenSubtitle = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 12.sp,
        lineHeight = 16.sp,
        color      = LumenColor.TextMuted
    )

    /**
     * Answer input text. User's typed responses in check-in.
     * 13sp DM Sans light.
     */
    val InputText = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 13.sp,
        lineHeight = 19.5.sp,           // 1.5x
        color      = LumenColor.TextPrimary
    )

    /**
     * Calendar day number. 11sp DM Sans.
     * Weight and color vary by state — applied at the composable level.
     */
    val CalendarDay = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize   = 11.sp,
        lineHeight = 11.sp,
        color      = LumenColor.TextMuted
    )

    /**
     * Entry preview text in timeline rows.
     * 12sp DM Sans light, single line truncated.
     */
    val EntryPreview = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 12.sp,
        lineHeight = 16.sp,
        color      = LumenColor.TextMuted
    )

    /**
     * Stat card description. "Total check-ins", "Avg mood score".
     * 10sp DM Sans regular, tracked.
     */
    val StatDesc = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Normal,
        fontSize      = 10.sp,
        lineHeight    = 13.sp,
        letterSpacing = 0.4.sp,
        color         = LumenColor.TextMuted
    )

    /**
     * Member since / streak label text.
     * 11sp DM Sans light.
     */
    val MetaLabel = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 11.sp,
        lineHeight = 14.sp,
        color      = LumenColor.TextMuted
    )

    /**
     * Insight body text inside the hero card.
     * 13sp DM Sans light, relaxed line height.
     */
    val InsightBody = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 13.sp,
        lineHeight = 22.1.sp,           // 1.7x
        color      = LumenColor.TextMuted
    )

    /**
     * Pattern chip description text.
     * 13sp DM Sans light.
     */
    val PatternBody = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 13.sp,
        lineHeight = 20.8.sp,           // 1.6x
        color      = LumenColor.TextMuted
    )

    /**
     * Pattern chip title. Bold within pattern body.
     * 13sp DM Sans regular.
     */
    val PatternTitle = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize   = 13.sp,
        lineHeight = 16.sp,
        color      = LumenColor.TextPrimary
    )

    // ── Labels & Caps (DM Sans) ──────────────────────────────
    // Small all-caps tracking labels used throughout the UI.

    /**
     * Section label. "CHECK-IN", "YOUR DATA", "CURRENT STREAK".
     * 10sp DM Sans medium, wide tracking, uppercase.
     */
    val SectionLabel = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Medium,
        fontSize      = 10.sp,
        lineHeight    = 12.sp,
        letterSpacing = 1.2.sp,
        color         = LumenColor.TextMuted
    )

    /**
     * Eyebrow label above headlines in onboarding.
     * "LET'S GET ACQUAINTED", "YOUR INTENTION".
     * 10sp DM Sans medium, wide tracking, uppercase.
     */
    val Eyebrow = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Medium,
        fontSize      = 10.sp,
        lineHeight    = 12.sp,
        letterSpacing = 1.4.sp,
        color         = LumenColor.TextMuted
    )

    /**
     * Mood orb word label. "GREAT", "GOOD", "OKAY".
     * 8sp DM Sans regular, tracked, uppercase.
     */
    val OrbLabel = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Normal,
        fontSize      = 8.sp,
        lineHeight    = 8.sp,
        letterSpacing = 0.4.sp,
        color         = LumenColor.TextMuted
    )

    /**
     * Mood selector prompt above orbs.
     * "HOW ARE YOU FEELING RIGHT NOW?"
     * 11sp DM Sans regular, tracked, uppercase.
     */
    val MoodPrompt = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Normal,
        fontSize      = 11.sp,
        lineHeight    = 13.sp,
        letterSpacing = 1.32.sp,
        color         = LumenColor.TextMuted
    )

    /**
     * Nav bar label. "TODAY", "TIMELINE", "INSIGHTS", "PROFILE".
     * 9sp DM Sans medium, tracked, uppercase.
     */
    val NavLabel = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Medium,
        fontSize      = 9.sp,
        lineHeight    = 9.sp,
        letterSpacing = 0.54.sp,
        color         = LumenColor.TextMuted
    )

    /**
     * Calendar day-of-week column header. "S M T W T F S".
     * 9sp DM Sans regular, tracked, uppercase.
     */
    val CalendarHeader = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Normal,
        fontSize      = 9.sp,
        lineHeight    = 9.sp,
        letterSpacing = 0.72.sp,
        color         = LumenColor.TextMuted
    )

    /**
     * Character counter below answer input.
     * "47 / 300". 10sp DM Sans regular.
     */
    val CharCounter = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize   = 10.sp,
        lineHeight = 12.sp,
        color      = LumenColor.TextMuted
    )

    /**
     * Input hint text below text fields.
     * "Only stored on your device." 11sp DM Sans light.
     */
    val InputHint = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 11.sp,
        lineHeight = 14.sp,
        color      = LumenColor.TextMuted
    )

    /**
     * Tip card small print.
     * "Processed securely via Google Play · No subscription"
     * 11sp DM Sans light, centered.
     */
    val TipSmallPrint = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 11.sp,
        lineHeight = 14.sp,
        textAlign  = TextAlign.Center,
        color      = LumenColor.TextMuted
    )

    /**
     * Month/period tab chip. "Nov", "Dec", "Feb".
     * 12sp DM Sans regular.
     */
    val PeriodTab = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize   = 12.sp,
        lineHeight = 14.sp,
        color      = LumenColor.TextMuted
    )

    /**
     * Privacy screen item title. "Stored on your device".
     * 13sp DM Sans regular.
     */
    val PrivacyTitle = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize   = 13.sp,
        lineHeight = 16.sp,
        color      = LumenColor.TextPrimary
    )

    /**
     * Privacy screen item description.
     * 11sp DM Sans light, relaxed line height.
     */
    val PrivacyDesc = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 11.sp,
        lineHeight = 17.05.sp,          // 1.55x
        color      = LumenColor.TextMuted
    )

    // ── Buttons ─────────────────────────────────────────────

    /**
     * Primary CTA button label. "Complete Check-In →", "Get Started".
     * 14sp DM Sans medium, slightly tracked.
     */
    val ButtonPrimary = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Medium,
        fontSize      = 14.sp,
        lineHeight    = 14.sp,
        letterSpacing = 0.56.sp,
        color         = LumenColor.OnPrimary
    )

    /**
     * Ghost / outline button label. "I already have an account".
     * 13sp DM Sans regular.
     */
    val ButtonGhost = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Normal,
        fontSize      = 13.sp,
        lineHeight    = 13.sp,
        letterSpacing = 0.52.sp,
        color         = LumenColor.TextMuted
    )

    /**
     * Tip amount label on tip tier button. "$1", "$3", "$5".
     * 18sp Fraunces light, gold.
     */
    val TipAmount = TextStyle(
        fontFamily = FrauncesFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 18.sp,
        lineHeight = 18.sp,
        color      = LumenColor.AccentGold
    )

    /**
     * Tip tier descriptor. "A sip ☕", "A cup ☕☕".
     * 9sp DM Sans regular, tracked, uppercase.
     */
    val TipTierLabel = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Normal,
        fontSize      = 9.sp,
        lineHeight    = 11.sp,
        letterSpacing = 0.72.sp,
        color         = LumenColor.TextMuted
    )

    // ── Step / Progress ─────────────────────────────────────

    /**
     * Onboarding step badge. "STEP 2 OF 7".
     * 10sp DM Sans medium, tracked, violet.
     */
    val StepBadge = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Medium,
        fontSize      = 10.sp,
        lineHeight    = 12.sp,
        letterSpacing = 1.0.sp,
        color         = LumenColor.AccentViolet
    )

    /**
     * Week label above insight hero card. "THIS WEEK'S SUMMARY".
     * 10sp DM Sans regular, tracked, uppercase.
     */
    val InsightWeekLabel = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Normal,
        fontSize      = 10.sp,
        lineHeight    = 12.sp,
        letterSpacing = 1.5.sp,
        color         = LumenColor.TextMuted
    )

    /**
     * Trend label above chart. "MOOD TREND".
     * Same as SectionLabel.
     */
    val TrendLabel = SectionLabel

    /**
     * Time picker AM/PM label.
     * 12sp DM Sans medium, tracked.
     */
    val TimePicker = TextStyle(
        fontFamily    = DmSansFamily,
        fontWeight    = FontWeight.Medium,
        fontSize      = 12.sp,
        lineHeight    = 14.sp,
        letterSpacing = 0.6.sp,
        color         = LumenColor.TextMuted
    )

    /**
     * Time picker selected value.
     * 32sp Fraunces light.
     */
    val TimePickerSelected = TextStyle(
        fontFamily = FrauncesFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 32.sp,
        lineHeight = 38.sp,
        color      = LumenColor.TextPrimary
    )

    /**
     * Time reminder note below time picker.
     * "One check-in per day — a single, intentional moment."
     * 11sp DM Sans light, centered.
     */
    val TimeNote = TextStyle(
        fontFamily = DmSansFamily,
        fontWeight = FontWeight.Light,
        fontSize   = 11.sp,
        lineHeight = 18.15.sp,          // 1.65x
        textAlign  = TextAlign.Center,
        color      = LumenColor.TextMuted
    )
}

// ─────────────────────────────────────────────────────────────
// Material 3 Typography mapping
//
// Maps Lumen's custom styles to Material 3 Typography slots
// so that M3 components (buttons, dialogs, etc.) pick up the
// right typeface automatically without needing overrides
// at every usage site.
// ─────────────────────────────────────────────────────────────

val LumenTypography = Typography(
    // Display slots — largest Fraunces headings
    displayLarge  = LumenTextStyle.Greeting,
    displayMedium = LumenTextStyle.OnboardingHeadline,
    displaySmall  = LumenTextStyle.ScreenTitle,

    // Headline slots — card and section headings
    headlineLarge  = LumenTextStyle.InsightHeadline,
    headlineMedium = LumenTextStyle.TipTitle,
    headlineSmall  = LumenTextStyle.UserName,

    // Title slots — settings labels, option card labels
    titleLarge  = LumenTextStyle.SettingsLabel,
    titleMedium = LumenTextStyle.PrivacyTitle,
    titleSmall  = LumenTextStyle.PatternTitle,

    // Body slots — descriptive copy
    bodyLarge  = LumenTextStyle.Body,
    bodyMedium = LumenTextStyle.InsightBody,
    bodySmall  = LumenTextStyle.PrivacyDesc,

    // Label slots — small UI labels, buttons, counters
    labelLarge  = LumenTextStyle.ButtonPrimary,
    labelMedium = LumenTextStyle.SectionLabel,
    labelSmall  = LumenTextStyle.NavLabel,
)
