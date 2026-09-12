package com.example.composenavigationseatwork.ui.theme

import androidx.compose.ui.graphics.Color
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DarkBlue,
    secondary = DarkBlue,
    tertiary = DarkBlue,

    background = DarkSurface,
    surface = DarkSurface,
    surfaceVariant = DarkCard
)

private val LightColorScheme = lightColorScheme(
    primary = NavyBlue,
    onPrimary = Color.White,

    primaryContainer = LightBlue,
    onPrimaryContainer = DarkText,

    secondary = NavyBlue,
    onSecondary = Color.White,

    tertiary = NavyBlue,

    background = AppBackground,
    onBackground = DarkText,

    surface = AppBackground,
    onSurface = DarkText,

    surfaceVariant = FieldBackground,
    onSurfaceVariant = GreyText,

    surfaceContainerLowest = Color.White,
    surfaceContainerLow = CardBackground,
    surfaceContainer = CardBackground,
    surfaceContainerHigh = FieldBackground,
    surfaceContainerHighest = FieldBackground,

    outline = BorderColor,
    outlineVariant = Color(0xFFB8C4D1)
)

@Composable
fun ComposeNavigationSeatworkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}