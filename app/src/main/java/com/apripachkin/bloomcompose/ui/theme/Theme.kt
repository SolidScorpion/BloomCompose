package com.apripachkin.bloomcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
  primary = Pink900,
  primaryVariant = Purple700,
  secondary = Green300,
  background = Gray,
  surface = White150,
  onBackground = White,
  onSurface = White850
)

private val LightColorPalette = lightColors(
  primary = Pink100,
  primaryVariant = Purple700,
  secondary = Pink900,
  background = White,
  surface = White850,
  onPrimary = Gray,
  onSecondary = White,
  onBackground = Gray,
  onSurface = Gray

  /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BloomComposeTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colors = if (darkTheme) {
    DarkColorPalette
  } else {
    LightColorPalette
  }

  MaterialTheme(
    colors = colors,
    typography = Typography,
    shapes = Shapes,
    content = content
  )
}