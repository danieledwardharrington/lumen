package com.deh.lumen.profile.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class ProfileItem(
    private val iconRes: Int,
    private val iconColor: Color,
    private val titleRes: Int,
    private val descriptionRes: Int,
    private val onClick: () -> Unit,
    private val endAction: @Composable () -> Unit
)