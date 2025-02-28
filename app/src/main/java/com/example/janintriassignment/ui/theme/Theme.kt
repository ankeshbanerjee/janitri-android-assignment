package com.example.janintriassignment.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF9C4DB9),
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFC8ADFC),
    surfaceVariant = Color(0xFFEBB9FE),
    onSurfaceVariant = Color(0xFF3F0A71),
    onSurface = Color(0xFF5F1C9C),
    outline = Color(0xFF6A676E)
)

@Composable
fun JanintriAssignmentTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}