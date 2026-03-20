package com.deh.lumen.profile.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.deh.lumen.core_ui.theme.LumenTheme

@Composable
fun AllTimeCard(
    modifier: Modifier = Modifier,
    largeText: String,
    largeTextColor: Color,
    subText: String,
    subTextColor: Color
) {
    // Cards need to be 1/3 size of screen minus sum of padding and row spacing
    val cardDimen = LocalConfiguration.current.screenWidthDp - 56

    Card(
        modifier = modifier
            .size(cardDimen.dp, cardDimen.dp),
        shape = LumenTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = LumenTheme.colors.surface
        ),
        border = BorderStroke(1.dp, LumenTheme.colors.outline),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = largeText,
                color = largeTextColor,
                style = LumenTheme.typography.headlineSmall.copy(fontStyle = FontStyle.Normal)
            )

            Text(
                text = subText,
                color = subTextColor,
                style = LumenTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}