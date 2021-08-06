package com.apripachkin.bloomcompose

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apripachkin.bloomcompose.data.Data
import com.apripachkin.bloomcompose.data.HomeViewState
import com.apripachkin.bloomcompose.data.homeGardenThemes
import com.apripachkin.bloomcompose.data.sampleData
import com.apripachkin.bloomcompose.ui.theme.BloomComposeTheme

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
  val collectAsState = homeViewModel.viewState.collectAsState()
  HomeScreenScaffold(state = collectAsState.value)
}

@Composable
private fun HomeScreenScaffold(
  state: HomeViewState,
) {
  Scaffold(
    bottomBar = {
      BloomBottomBar()
    }
  ) {
    if (state.showLoading) {
      HomeScreenLoader(it)
    } else {
      HomeScreenContent(it, state)
    }
  }
}

@Composable
private fun HomeScreenLoader(paddingValues: PaddingValues) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .padding(paddingValues = paddingValues)
  ) {
    CircularProgressIndicator(
      modifier = Modifier
        .wrapContentSize()
        .align(Alignment.Center)
    )
  }
}

@Composable
private fun BloomBottomBar() {
  BottomAppBar(
    backgroundColor = MaterialTheme.colors.primary
  ) {
    BloomBottomButton(
      selected = true,
      icon = Icons.Default.Home,
      labelText = "Home"
    )
    BloomBottomButton(
      selected = false,
      icon = Icons.Default.FavoriteBorder,
      labelText = "Favorites"
    )
    BloomBottomButton(
      selected = false,
      icon = Icons.Default.AccountCircle,
      labelText = "Account"
    )
    BloomBottomButton(
      selected = false,
      icon = Icons.Default.ShoppingCart,
      labelText = "Cart"
    )
  }
}

@Composable
private fun RowScope.BloomBottomButton(
  selected: Boolean,
  icon: ImageVector,
  labelText: String
) {
  BottomNavigationItem(
    selected = selected,
    onClick = { /*TODO*/ },
    icon = {
      Icon(icon, contentDescription = null)
    },
    label = {
      Text(text = labelText)
    }
  )
}

@Composable
private fun HomeScreenContent(
  paddingValues: PaddingValues,
  state: HomeViewState
) {
  Surface(
    color = MaterialTheme.colors.background,
    modifier = Modifier
      .fillMaxSize()
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())
        .padding(paddingValues)
    ) {
      Spacer(modifier = Modifier.height(40.dp))
      SearchInput()
      BrowseThemesSection(
        state.plantThemes
      )
      HomeGardenSection(
        state.homeGardenItems
      )
    }
  }
}

@Composable
private fun HomeGardenSection(homeGardenItems: List<Data>) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .padding(horizontal = 16.dp)
  ) {
    Text(
      text = "Design your home garden",
      style = MaterialTheme.typography.h1,
      modifier = Modifier
        .paddingFromBaseline(
          top = 40.dp,
          bottom = 16.dp
        )
        .weight(1f)
    )
    Icon(
      Icons.Default.FilterList,
      contentDescription = "Filter",
      modifier = Modifier
        .size(24.dp)
    )
  }
  Column(
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier
      .padding(horizontal = 16.dp)
      .padding(bottom = 16.dp)
  ) {
    homeGardenItems.forEach {
      HomeGardenListItem(data = it)
    }
  }
}

@Composable
private fun BrowseThemesSection(plantThemes: List<Data>) {
  Text(
    text = "Browse themes",
    style = MaterialTheme.typography.h1,
    modifier = Modifier
      .paddingFromBaseline(32.dp)
      .padding(horizontal = 16.dp)
  )
  Spacer(modifier = Modifier.height(16.dp))
  Row(
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier
      .horizontalScroll(rememberScrollState())
      .padding(horizontal = 16.dp)
  ) {
    plantThemes.forEach { PlantThemeCard(data = it) }
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
    HomeScreenScaffold(
      HomeViewState(
        sampleData.slice(0..2),
        homeGardenThemes.slice(0..2)
      )
    )
  }
}