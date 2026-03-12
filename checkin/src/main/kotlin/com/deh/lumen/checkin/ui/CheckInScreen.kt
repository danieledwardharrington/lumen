package com.deh.lumen.checkin.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deh.lumen.checkin.R
import com.deh.lumen.checkin.models.Mood
import com.deh.lumen.core_ui.composables.LumenButton
import com.deh.lumen.core_ui.theme.LumenTheme

@Composable
fun CheckInScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LumenTheme.colors.background),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(LumenTheme.colors.background),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CheckInTitle(
                greetingRes = R.string.greeting_morning,
                titleQuestionRes = greetingQuestions().random(),
                displayName = "Daniel"
            )

            CheckInMoodSelection(
                moods = Mood.entries,
                onMoodChange = {}
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CheckInQuestionBox(
                    checkInQuestion = "What's been weighing on you most today?",
                    onResponseChanged = {}
                )

                CheckInQuestionBox(
                    checkInQuestion = "Is there anything that gave you even a small moment of relief?",
                    onResponseChanged = {}
                )
            }
        }

        LumenButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            buttonText = stringResource(R.string.complete_check_in),
            onButtonClick = {}
        )
    }
}

private fun greetingQuestions() = listOf(
    R.string.greeting_question_1,
    R.string.greeting_question_2,
    R.string.greeting_question_3,
    R.string.greeting_question_4,
    R.string.greeting_question_5,
    R.string.greeting_question_6,
    R.string.greeting_question_7,
    R.string.greeting_question_8,
    R.string.greeting_question_9,
    R.string.greeting_question_10,
    R.string.greeting_question_11,
    R.string.greeting_question_12,
    R.string.greeting_question_13,
    R.string.greeting_question_14,
    R.string.greeting_question_15
)

@Composable
@Preview
private fun PreviewCheckInScreen() {
    LumenTheme {
        CheckInScreen()
    }
}