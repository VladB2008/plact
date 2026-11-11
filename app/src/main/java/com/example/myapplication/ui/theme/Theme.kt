package com.example.myapplication.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


private val LightColorScheme = lightColorScheme(

   primary = Accent,

    secondaryContainer = Accent,
    onSecondaryContainer = Color.White,

    background = Background,
    onBackground = TextMain,

    surface = Color.White,
surfaceContainerHighest = Color.White,


    surfaceContainerLow = Color.White,
    onSurface = TextMain,
onSurfaceVariant = TextSecond,
    )


val AppShapes = Shapes(
    RoundedCornerShape(12.dp), small = RoundedCornerShape(17.dp),
    RoundedCornerShape(16.dp), extraLarge = RoundedCornerShape(24.dp)
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {


    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = AppShapes,
        content = content
    )
}