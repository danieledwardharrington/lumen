package com.deh.lumen.core_data.models

import com.deh.lumen.core_data.entity.enum.SafetyConfidence

data class SafetyStatus(
    val flagged: Boolean,
    val confidence: SafetyConfidence
)