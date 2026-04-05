package com.deh.lumen.core_ui.composables

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.deh.lumen.core_ui.theme.LumenTheme

@Composable
fun LumenSwitch(
    isChecked: Boolean,
    onCheckChange: (Boolean, Int) -> Unit,
    itemTitleRes: Int
) {
    var checked by remember { mutableStateOf(isChecked) }
    Switch(
        checked = checked,
        onCheckedChange = {
            onCheckChange(it, itemTitleRes)
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = LumenTheme.colors.onPrimary,
            uncheckedThumbColor = LumenTheme.colors.onSurfaceVariant,
            checkedTrackColor = LumenTheme.colors.primary,
            uncheckedTrackColor = LumenTheme.colors.surfaceVariant,
            checkedBorderColor = Color.Transparent,
            uncheckedBorderColor = LumenTheme.colors.outline,
            disabledCheckedThumbColor = LumenTheme.colors.onPrimary.copy(alpha = 0.38f),
            disabledUncheckedThumbColor = LumenTheme.colors.onSurfaceVariant.copy(alpha = 0.38f),
            disabledCheckedTrackColor = LumenTheme.colors.primary.copy(alpha = 0.12f),
            disabledUncheckedTrackColor = LumenTheme.colors.surfaceVariant.copy(alpha = 0.12f),
            disabledCheckedBorderColor = Color.Transparent,
            disabledUncheckedBorderColor = LumenTheme.colors.outline.copy(alpha = 0.12f)
        )
    )
}