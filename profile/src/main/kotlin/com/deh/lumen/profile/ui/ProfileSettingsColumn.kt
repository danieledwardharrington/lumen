package com.deh.lumen.profile.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.deh.lumen.core_ui.theme.LumenTheme
import com.deh.lumen.profile.models.ProfileItem

@Composable
fun ProfileSettingsColumn(
    modifier: Modifier,
    profileItems: List<ProfileItem>
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = LumenTheme.colors.surface
        ),
        border = BorderStroke(1.dp, LumenTheme.colors.outline),
        shape = LumenTheme.shapes.small
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            for (profileItem in profileItems) {
                item {
                    ProfileSettingRow(
                        startIconRes = profileItem.iconRes,
                        startIconTint = profileItem.iconColor,
                        startIconBackgroundColor = profileItem.iconBackgroundColor,
                        titleTextRes = profileItem.titleRes,
                        descriptionRes = profileItem.descriptionRes,
                        endAction = profileItem.endAction
                    )
                }
                if (profileItem != profileItems.last()) {
                    item {
                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth(),
                            thickness = 1.dp,
                            color = LumenTheme.colors.outline
                        )
                    }
                }
            }
        }
    }
}