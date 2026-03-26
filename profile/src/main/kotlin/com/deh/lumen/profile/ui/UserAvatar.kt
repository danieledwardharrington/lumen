package com.deh.lumen.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.deh.lumen.core_ui.theme.LumenTheme

@Composable
fun UserAvatar(
    modifier: Modifier = Modifier,
    firstInitial: Char
) {
    Box(
        modifier = modifier
            .size(52.dp)
            .clip(CircleShape)
            .background(brush = LumenTheme.extendedColors.gradientCta)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = firstInitial.uppercase(),
            style = LumenTheme.typography.headlineSmall.copy(fontStyle = FontStyle.Normal),
            color = LumenTheme.colors.onPrimary
        )
    }
}