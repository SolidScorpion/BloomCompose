package com.apripachkin.bloomcompose

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apripachkin.bloomcompose.data.sampleData
import com.apripachkin.bloomcompose.ui.theme.BloomComposeTheme

@Composable
fun HomeScreen() {
  Surface(
    color = MaterialTheme.colors.background,
    modifier = Modifier.fillMaxSize()
  ) {
    Column {
      Spacer(modifier = Modifier.height(40.dp))
      SearchInput()
      BrowseThemesSection()
      HomeGardenSection()
    }
  }
}

@Composable
private fun HomeGardenSection() {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .padding(horizontal = 16.dp)
  ) {
    Text(
      text = "Design your home garden",
      style = MaterialTheme.typography.h1,
      modifier = Modifier
        .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
        .weight(1f)
    )
    Icon(
      Icons.Default.FilterList,
      contentDescription = "Filter",
      modifier = Modifier
        .size(24.dp)
        .alignByBaseline()
    )
  }
}

@Composable
private fun BrowseThemesSection() {
  Text(
    text = "Browse themes",
    style = MaterialTheme.typography.h1,
    modifier = Modifier
      .paddingFromBaseline(32.dp)
      .padding(16.dp)
  )
  Spacer(modifier = Modifier.height(16.dp))
  Row(
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier
      .horizontalScroll(rememberScrollState())
      .padding(horizontal = 16.dp)
  ) {
    sampleData.forEach { PlantThemeCard(data = it) }
  }
}

@Composable
private fun SearchInput() {
  OutlinedTextField(
    value = "",
    onValueChange = {},
    label = {
      Text("Text")
    }, leadingIcon = {
    Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(18.dp))
  },
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp)
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
fun PreviewDarkHome() {
  BloomComposeTheme {
    HomeScreen()
  }
}