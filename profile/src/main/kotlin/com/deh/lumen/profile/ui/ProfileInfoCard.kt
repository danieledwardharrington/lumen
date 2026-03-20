package com.deh.lumen.profile.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.deh.lumen.core_ui.theme.LumenTheme

@Composable
fun ProfileInfoCard(
    modifier: Modifier = Modifier,
    startComposable: @Composable () -> Unit,
    middleComposable: @Composable () -> Unit,
    endComposable: @Composable () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = LumenTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = LumenTheme.colors.surface
        ),
        border = BorderStroke(1.dp, LumenTheme.colors.outline),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
       Row(
           modifier = Modifier
               .padding(16.dp),
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceBetween
       ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                startComposable()
                middleComposable()
            }

           endComposable()
       }
    }
}