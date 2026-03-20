package com.deh.lumen.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.deh.lumen.core_ui.theme.LumenTheme
import kotlinx.datetime.LocalTime

@Composable
fun ProfileSettingRow(
    modifier: Modifier = Modifier,
    startIconRes: Int,
    startIconTint: Color,
    startIconBackgroundColor: Color,
    titleTextRes: Int,
    descriptionRes: Int,
    checkInTime: LocalTime? = null, // only used for check in time setting
    endAction: @Composable () -> Unit
) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(color = startIconBackgroundColor)
                    .clip(shape = LumenTheme.shapes.small)
            ) {
                Icon(
                    modifier = Modifier
                        .align(Alignment.Center),
                    painter = painterResource(startIconRes),
                    contentDescription = "${stringResource(titleTextRes)} item",
                    tint = startIconTint
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stringResource(titleTextRes),
                    color = LumenTheme.colors.onSurface,
                    style = LumenTheme.typography.titleMedium
                )

                Text(
                    text = stringResource(descriptionRes),
                    color = LumenTheme.colors.onSurfaceVariant,
                    style = LumenTheme.typography.bodyMedium
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (checkInTime != null) {
                Text(
                    text = checkInTime.toString(),
                    style = LumenTheme.typography.titleSmall,
                    color = LumenTheme.colors.onSurfaceVariant
                )
            }

            endAction()
        }
    }
}