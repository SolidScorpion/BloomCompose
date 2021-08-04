package com.apripachkin.bloomcompose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apripachkin.bloomcompose.data.Data
import com.apripachkin.bloomcompose.data.homeGardenThemes
import com.apripachkin.bloomcompose.ui.theme.BloomComposeTheme

@Composable
fun HomeGardenListItem(data: Data) {
  Row(
    horizontalArrangement = Arrangement.spacedBy(16.dp),
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .fillMaxWidth()
  ) {
    PlantImage(data)
    Column {
      TitleAndDescriptionCheckboxRow(data)
      Divider()
    }
  }
}

@Composable
private fun TitleAndDescriptionCheckboxRow(data: Data) {
  Row(
    verticalAlignment = Alignment.CenterVertically
  ) {
    TitleAndDescription(data)
    PlantCheckbox()
  }
}

@Composable
private fun PlantCheckbox() {
  var checkState by remember {
    mutableStateOf(true)
  }

  Checkbox(
    checked = checkState,
    onCheckedChange = {
      checkState = it
    },
    colors = CheckboxDefaults.colors(
      checkmarkColor = MaterialTheme.colors.background
    ),
    modifier = Modifier
      .size(24.dp)
  )
}

@Composable
private fun RowScope.TitleAndDescription(data: Data) {
  Column(
    modifier = Modifier
      .weight(1F)
  ) {
    Text(
      text = data.name,
      style = MaterialTheme.typography.h2,
      modifier = Modifier
        .paddingFromBaseline(top = 24.dp)
    )
    Text(
      text = "This is description",
      style = MaterialTheme.typography.body1,
      modifier = Modifier
        .paddingFromBaseline(bottom = 24.dp)
    )
  }
}

@Composable
private fun PlantImage(data: Data) {
  Image(
    painter = painterResource(id = data.imageRes),
    contentDescription = data.name,
    contentScale = ContentScale.Crop,
    modifier = Modifier
      .clip(MaterialTheme.shapes.small)
      .size(64.dp)
  )
}

@Preview(
  name = "Night Mode",
  uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
  name = "Day Mode",
  uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
private fun Preview() {
  BloomComposeTheme {
    Surface(color = MaterialTheme.colors.background) {
      HomeGardenListItem(data = homeGardenThemes.first())
    }
  }
}