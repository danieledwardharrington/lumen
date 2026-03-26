package com.deh.lumen.profile.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deh.lumen.core_ui.theme.LumenTheme
import com.deh.lumen.profile.R

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
            containerColor = LumenTheme.colors.surfaceVariant
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

@Composable
@Preview
private fun PreviewProfileInfo() {
    LumenTheme {
        ProfileInfoCard(
            startComposable = {
                UserAvatar(
                    firstInitial = 'D'
                )
            },
            middleComposable = {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Daniel",
                        style = LumenTheme.typography.titleLarge.copy(
                            fontStyle = FontStyle.Normal,
                            fontSize = 14.sp,
                            lineHeight = 20.sp
                        ),
                        color = LumenTheme.colors.onSurface
                    )

                    Text(
                        text = "Member since January 2026",
                        style = LumenTheme.typography.bodySmall,
                        color = LumenTheme.colors.onSurfaceVariant
                    )
                }
            },
            endComposable =  {
                IconButton(
                    onClick = {
                    },
                    shape = CircleShape
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(LumenTheme.colors.onPrimary.copy(alpha = 0.05f))
                            .clip(CircleShape)
                            .border(width = 1.dp, color = LumenTheme.colors.onPrimary.copy(alpha = 0.07f))
                    ) {
                        Icon(
                            modifier = Modifier.align(Alignment.Center),
                            painter = painterResource(R.drawable.ic_edit),
                            contentDescription = "Edit name",
                            tint = LumenTheme.colors.onSurfaceVariant
                        )
                    }
                }
            }
        )
    }
}

@Composable
@Preview
private fun PreviewActiveStreak() {
    LumenTheme {
        ProfileInfoCard(
            startComposable = {
                Icon(
                    painter = painterResource(R.drawable.ic_flame),
                    contentDescription = "Current streak",
                    tint = LumenTheme.colors.tertiary
                )
            },
            middleComposable = {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "31",
                        style = LumenTheme.typography.headlineSmall.copy(fontStyle = FontStyle.Normal),
                        color = LumenTheme.colors.tertiary
                    )

                    Text(
                        text = stringResource(R.string.days_in_a_row),
                        style = LumenTheme.typography.bodySmall,
                        color = LumenTheme.colors.onSurfaceVariant
                    )
                }
            },
            endComposable =  {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "44",
                        style = LumenTheme.typography.titleSmall,
                        color = LumenTheme.colors.onSurface
                    )

                    Text(
                        text = stringResource(R.string.personal_best).uppercase(),
                        style = LumenTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
                        color = LumenTheme.colors.onSurfaceVariant
                    )
                }
            }
        )
    }
}

@Composable
@Preview
private fun PreviewInactiveStream() {
    LumenTheme {
        ProfileInfoCard(
            startComposable = {
                Icon(
                    painter = painterResource(R.drawable.ic_flame),
                    contentDescription = "Current streak",
                    tint = LumenTheme.colors.onSurfaceVariant.copy(alpha = 0.4f)
                )
            },
            middleComposable = {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "0",
                        style = LumenTheme.typography.headlineSmall.copy(fontStyle = FontStyle.Normal),
                        color = LumenTheme.colors.onSurfaceVariant.copy(alpha = 0.4f)
                    )

                    Text(
                        text = stringResource(R.string.days_in_a_row),
                        style = LumenTheme.typography.bodySmall,
                        color = LumenTheme.colors.onSurfaceVariant
                    )
                }
            },
            endComposable =  {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "44",
                        style = LumenTheme.typography.titleSmall,
                        color = LumenTheme.colors.onSurface
                    )

                    Text(
                        text = stringResource(R.string.personal_best).uppercase(),
                        style = LumenTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
                        color = LumenTheme.colors.onSurfaceVariant
                    )
                }
            }
        )
    }
}