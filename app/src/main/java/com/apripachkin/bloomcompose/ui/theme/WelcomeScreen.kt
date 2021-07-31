package com.apripachkin.bloomcompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apripachkin.bloomcompose.R.drawable

@Composable
fun WelcomeScreen() {
  Surface(
    color = MaterialTheme.colors.primary,
    modifier = Modifier
      .fillMaxSize()
  ) {
    WelcomeBackground()
    WelcomeScreenContent()
  }
}

@Composable
private fun WelcomeScreenContent() {
  Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(modifier = Modifier.height(72.dp))
    LeafImage()
    Spacer(modifier = Modifier.height(48.dp))
    LogoImage()
    AppSubtitle()
    Spacer(modifier = Modifier.height(40.dp))
    CreateAccountButton()
    Spacer(modifier = Modifier.height(8.dp))
    LoginButton()
  }
}

@Composable
private fun LeafImage() {
  val light = MaterialTheme.colors.isLight
  val welcomeImage = if (light) drawable.ic_welcome_illos else drawable.ic_welcome_illos_night
  Image(
    painter = painterResource(id = welcomeImage), contentDescription = null, modifier = Modifier.offset(
    x = 88.dp
  )
  )
}

@Composable
private fun LogoImage() {
  val light = MaterialTheme.colors.isLight
  val logo = if (light) drawable.ic_logo else drawable.ic_logo_night
  Image(painter = painterResource(id = logo), contentDescription = null)
}

@Composable
private fun AppSubtitle() {
  Text(
    text = "Beautiful garden solutions", style = MaterialTheme.typography.subtitle1,
    modifier = Modifier.paddingFromBaseline(32.dp)
  )
}

@Composable
private fun LoginButton() {
  val textColor = if (MaterialTheme.colors.isLight) {
    Pink900
  } else {
    White
  }
  TextButton(
    onClick = { /*TODO*/ },
    modifier = Modifier.fillMaxWidth()
      .padding(horizontal = 16.dp),

  ) {
    Text(text = "Log in", color = textColor)
  }
}

@Composable
private fun CreateAccountButton() {
  Button(
    onClick = { /*TODO*/ },
    modifier = Modifier.fillMaxWidth()
      .height(48.dp)
      .padding( horizontal = 16.dp),
    shape = MaterialTheme.shapes.medium,
    colors = buttonColors(
      backgroundColor = MaterialTheme.colors.secondary
    )

  ) {
    Text(text = "Create account")
  }
}

@Composable
private fun WelcomeBackground() {
  val image = if (MaterialTheme.colors.isLight) drawable.ic_welcome_bg else drawable.ic_welcome_bg_night
  Image(
    painter = painterResource(id = image), contentDescription = null,
    contentScale = ContentScale.FillBounds,
    modifier = Modifier.fillMaxSize()
  )
}

@Preview
@Composable
private fun PreviewDarkWelcomeScreen() {
  BloomComposeTheme(darkTheme = true) {
    WelcomeScreen()
  }
}

@Preview
@Composable
private fun PreviewLightScreen() {
  BloomComposeTheme(darkTheme = false) {
    WelcomeScreen()
  }
}