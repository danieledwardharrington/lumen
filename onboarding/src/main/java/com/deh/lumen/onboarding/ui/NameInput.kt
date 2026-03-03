package com.deh.lumen.onboarding.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.deh.lumen.core_ui.theme.LumenTheme

@Composable
fun NameInput(
    modifier: Modifier = Modifier,
    onNameChange: (String) -> Unit
) {
    var input by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        value = input,
        onValueChange = {
            input = it
            onNameChange(input)
        },
        textStyle = LumenTheme.typography.titleLarge.copy(fontStyle = FontStyle.Italic),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = LumenTheme.colorScheme.onBackground,
            unfocusedTextColor = LumenTheme.colorScheme.onBackground,
            focusedContainerColor = LumenTheme.colorScheme.surface,
            unfocusedContainerColor = LumenTheme.colorScheme.surface,
            focusedBorderColor = LumenTheme.colorScheme.outlineVariant,
            unfocusedBorderColor = LumenTheme.colorScheme.outline
        ),
        singleLine = true
    )
}