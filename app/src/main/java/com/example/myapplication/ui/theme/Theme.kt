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

   primary = Accent,//главный цвет кнопки,сылки, сердечки и тд.
    onPrimary = Color.White,// тцвет текста лежащие в главном цвете

    background = Background,// цвет фона
    onBackground = TextMain,// цвет основго цвета

    surface = Color.White,// фон карточек и тд.
surfaceContainerHighest = Color.White,// фон выпадающих окон


    surfaceContainerLow = Color.White,// фон для поиска
    onSurface = TextMain, // цвет текста на карточках
onSurfaceVariant = TextSecond, // цвет второстипенного текста на карточках
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

val colorScheme = LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = AppShapes,
        content = content
    )
}