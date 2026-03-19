package com.deh.lumen.core_data.models

import kotlinx.serialization.Serializable

@Serializable
data class QuestionAnswerPair(
    val question: String,
    val answer: String
)