package com.apripachkin.bloomcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apripachkin.bloomcompose.ui.theme.BloomComposeTheme

@Composable
fun LoginScreen() {
  Surface(
    color = MaterialTheme.colors.background,
    modifier = Modifier.fillMaxSize()
  ) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp),
    ) {
      LoginHeader()
      EmailInput()
      Spacer(modifier = Modifier.height(8.dp))
      PasswordInput()
      Text(
        text = "By clocking below you agree to our Terms of Use and consent to our Privacy Policy",
        style = MaterialTheme.typography.body2,
        modifier = Modifier.paddingFromBaseline(top = 24.dp),
        textAlign = TextAlign.Center
      )
      Spacer(modifier = Modifier.height(16.dp))
      LoginButton()
    }
  }
}

@Composable
private fun LoginButton() {
  BloomSecondaryButton(buttonText = "Login")
}

@Composable
private fun PasswordInput() {
  var text by remember {
    mutableStateOf("")
  }
  OutlinedTextField(
    value = text,
    onValueChange = {
                    text = it
    },
    visualTransformation = PasswordVisualTransformation() ,
    label = {
      Text(text = "Password (8+ characters)")
    },
    modifier = Modifier.fillMaxWidth()
  )
}

@Composable
private fun EmailInput() {
  var textState by remember {
    mutableStateOf("")
  }
  OutlinedTextField(
    value = textState,
    onValueChange = {
      textState = it
    },
    label = {
      Text(text = "Email address")
    },
    keyboardOptions = KeyboardOptions.Default.copy(
      keyboardType = KeyboardType.Email
    ),
    modifier = Modifier.fillMaxWidth(),
  )
}

@Composable
private fun LoginHeader() {
  Text(
    text = "Log in with email",
    style = MaterialTheme.typography.h1,
    modifier = Modifier.paddingFromBaseline(top = 184.dp, bottom = 16.dp)
  )
}

@Preview
@Composable
private fun PreviewDarkLogin() {
  BloomComposeTheme(darkTheme = true) {
    LoginScreen()
  }
}

@Preview
@Composable
private fun PreviewLightLogin() {
  BloomComposeTheme(darkTheme = false) {
    LoginScreen()
  }
}