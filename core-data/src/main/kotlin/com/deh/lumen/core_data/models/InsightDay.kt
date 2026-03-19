package com.deh.lumen.core_data.models

import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.format.DayOfWeekNames

enum class InsightDay(
    val shortName: String
) {
    MONDAY(DayOfWeekNames.ENGLISH_ABBREVIATED.names[0]),
    TUESDAY(DayOfWeekNames.ENGLISH_ABBREVIATED.names[1]),
    WEDNESDAY(DayOfWeekNames.ENGLISH_ABBREVIATED.names[2]),
    THURSDAY(DayOfWeekNames.ENGLISH_ABBREVIATED.names[3]),
    FRIDAY(DayOfWeekNames.ENGLISH_ABBREVIATED.names[4]),
    SATURDAY(DayOfWeekNames.ENGLISH_ABBREVIATED.names[5]),
    SUNDAY(DayOfWeekNames.ENGLISH_ABBREVIATED.names[6]);
}

fun DayOfWeek.toInsightDay(): InsightDay {
    return when (this) {
        DayOfWeek.MONDAY -> InsightDay.MONDAY
        DayOfWeek.TUESDAY -> InsightDay.TUESDAY
        DayOfWeek.WEDNESDAY -> InsightDay.WEDNESDAY
        DayOfWeek.THURSDAY -> InsightDay.THURSDAY
        DayOfWeek.FRIDAY -> InsightDay.FRIDAY
        DayOfWeek.SATURDAY -> InsightDay.SATURDAY
        DayOfWeek.SUNDAY -> InsightDay.SUNDAY
    }
}