package com.deh.lumen.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.deh.lumen.core_ui.theme.LumenTheme
import com.deh.lumen.onboarding.OnboardingStep
import com.deh.lumen.onboarding.R

@Composable
fun OnboardingScreen(
    onboardingStep: OnboardingStep
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
            .background(LumenTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val textAlignment = if (onboardingStep is OnboardingStep.Welcome) TextAlign.Center else TextAlign.Start

        if (onboardingStep.logo != null) {
            Image(
                painter = painterResource(onboardingStep.logo),
                contentDescription = stringResource(R.string.logo_content_description)
            )
        }

        if (onboardingStep.supertitleRes != null) {
            Text(
                text = stringResource(onboardingStep.supertitleRes).uppercase(),
                textAlign = textAlignment,
                style = LumenTheme.typography.bodyMedium,
                color = LumenTheme.colorScheme.onSurfaceVariant
            )
        }

        Text(
            text = stringResource(onboardingStep.titleRes),
            textAlign = textAlignment,
            style = LumenTheme.typography.headlineLarge.copy(fontStyle = FontStyle.Italic),
            color = LumenTheme.colorScheme.onBackground
        )

        if (onboardingStep.descriptionRes != null) {
            Text(
                text = stringResource(onboardingStep.descriptionRes),
                textAlign = TextAlign.Center,
                style = LumenTheme.typography.bodyMedium,
                color = LumenTheme.colorScheme.onSurfaceVariant
            )
        }

        when (onboardingStep) {
            is OnboardingStep.Name -> NameInput(
                onNameChange = {}
            )
            else -> {}
        }
    }
}