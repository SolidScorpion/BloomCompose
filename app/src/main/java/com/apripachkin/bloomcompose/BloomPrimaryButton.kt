package com.apripachkin.bloomcompose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BloomSecondaryButton(
  buttonText: String,
  modifier: Modifier = Modifier
) {
  Button(
    onClick = { /*TODO*/ },
    modifier = Modifier
      .fillMaxWidth()
      .height(48.dp)
      .padding(horizontal = 16.dp),
    shape = MaterialTheme.shapes.medium,
    colors = ButtonDefaults.buttonColors(
      backgroundColor = MaterialTheme.colors.secondary
    )

  ) {
    Text(text = "Create account")
  }
}