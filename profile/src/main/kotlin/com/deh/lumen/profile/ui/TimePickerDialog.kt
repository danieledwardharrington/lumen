package com.deh.lumen.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.deh.lumen.core_ui.theme.LumenTheme
import com.deh.lumen.profile.R
import kotlinx.datetime.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerDialog(
    modifier: Modifier = Modifier,
    checkInTime: LocalTime = LocalTime(21, 0),
    onDismissRequest: () -> Unit,
    onConfirmTime: (LocalTime) -> Unit
) {
    BasicAlertDialog(
        modifier = modifier
            .background(color = LumenTheme.colors.surface)
            .clip(LumenTheme.shapes.small),
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val timePickerState = rememberTimePickerState(
                initialHour = checkInTime.hour,
                initialMinute = checkInTime.minute,
                is24Hour = false
            )

            TimePicker(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                state = timePickerState,
                colors = TimePickerDefaults.colors(
                    clockDialColor = LumenTheme.colors.surfaceVariant,
                    clockDialSelectedContentColor = LumenTheme.colors.onPrimary,
                    clockDialUnselectedContentColor = LumenTheme.colors.onSurfaceVariant,
                    selectorColor = LumenTheme.colors.primary,
                    containerColor = LumenTheme.colors.surfaceVariant,
                    periodSelectorBorderColor = LumenTheme.colors.outline,
                    periodSelectorSelectedContainerColor = LumenTheme.colors.primaryContainer,
                    periodSelectorUnselectedContainerColor = Color.Transparent,
                    periodSelectorSelectedContentColor = LumenTheme.colors.onPrimaryContainer,
                    periodSelectorUnselectedContentColor = LumenTheme.colors.onSurfaceVariant,
                    timeSelectorSelectedContainerColor = LumenTheme.colors.primaryContainer,
                    timeSelectorUnselectedContainerColor = LumenTheme.colors.surfaceVariant,
                    timeSelectorSelectedContentColor = LumenTheme.colors.onPrimaryContainer,
                    timeSelectorUnselectedContentColor = LumenTheme.colors.onSurface,
                )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    TextButton(
                        onClick = onDismissRequest,
                    ) {
                        Text(
                            text = stringResource(R.string.dismiss),
                            style = LumenTheme.typography.labelMedium,
                            color = LumenTheme.colors.onSurfaceVariant
                        )
                    }

                    TextButton(
                        onClick = { onConfirmTime(LocalTime(hour = timePickerState.hour, minute = timePickerState.minute)) },
                    ) {
                        Text(
                            text = stringResource(R.string.confirm),
                            style = LumenTheme.typography.labelMedium,
                            color = LumenTheme.colors.onSurface
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun PreviewTimePickerDialog() {
    LumenTheme {
        TimePickerDialog(
            onDismissRequest = {},
            onConfirmTime = {}
        )
    }
}