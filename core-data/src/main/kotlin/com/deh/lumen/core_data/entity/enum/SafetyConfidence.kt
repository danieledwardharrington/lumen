package com.deh.lumen.core_data.entity.enum

enum class SafetyConfidence {
    CLEAR,
    LOW,
    MEDIUM,
    HIGH;

    companion object {
        fun fromString(value: String): SafetyConfidence = when (value.lowercase()) {
            "clear"  -> CLEAR
            "low"    -> LOW
            "medium" -> MEDIUM
            "high"   -> HIGH
            else     -> LOW
        }
    }
}