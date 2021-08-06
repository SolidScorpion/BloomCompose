package com.apripachkin.bloomcompose.data

data class HomeViewState(
  val plantThemes: List<Data> = emptyList(),
  val homeGardenItems: List<Data> = emptyList(),
) {
  val showLoading: Boolean
    get() = plantThemes.isEmpty() || homeGardenItems.isEmpty()
}
