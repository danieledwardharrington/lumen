package com.deh.lumen.profile.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class ProfileItem(
    val iconRes: Int,
    val iconColor: Color,
    val iconBackgroundColor: Color,
    val titleRes: Int,
    val descriptionRes: Int,
    val onClick: () -> Unit,
    val endAction: @Composable () -> Unit
)