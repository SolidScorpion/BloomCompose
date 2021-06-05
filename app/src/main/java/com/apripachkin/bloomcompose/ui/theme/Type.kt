package com.apripachkin.bloomcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.apripachkin.bloomcompose.R

// Set of Material typography styles to start with
val nunitoFamily = FontFamily(
  Font(R.font.nunito_sans_bold, FontWeight.Bold),
  Font(R.font.nunito_sans_light, FontWeight.Light),
  Font(R.font.nunito_sans_semi_bold, FontWeight.SemiBold)
)
val Typography = Typography(
  body1 = TextStyle(
    fontFamily = nunitoFamily,
    fontWeight = FontWeight.Light,
    fontSize = 14.sp,
    letterSpacing = 0.sp
  ),
  body2 = TextStyle(
    fontFamily = nunitoFamily,
    fontWeight = FontWeight.Light,
    fontSize = 12.sp,
    letterSpacing = 0.sp
  ),
  h1 = TextStyle(
    fontFamily = nunitoFamily,
    fontWeight = FontWeight.Bold,
    letterSpacing = 0.sp,
    fontSize = 18.sp
  ),
  h2 = TextStyle(
    fontFamily = nunitoFamily,
    fontWeight = FontWeight.Bold,
    letterSpacing = .15f.sp
  ),
  button = TextStyle(
    fontFamily = nunitoFamily,
    fontWeight = FontWeight.Bold,
    letterSpacing = 1f.sp,
    fontSize = 14.sp
  ),
  caption = TextStyle(
    fontFamily = nunitoFamily,
    fontWeight = FontWeight.Bold,
    letterSpacing = 0.sp,
    fontSize = 12.sp
  )
)