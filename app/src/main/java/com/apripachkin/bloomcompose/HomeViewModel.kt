package com.apripachkin.bloomcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apripachkin.bloomcompose.data.HomeViewState
import com.apripachkin.bloomcompose.data.PlantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
  private val plantRepository: PlantRepository
) : ViewModel() {
  private val _viewState = MutableStateFlow(HomeViewState())
  val viewState = _viewState.asStateFlow()

  init {
    fetchThemes()
    fetchHomeGardenThemes()
  }
  private fun fetchThemes() {
    viewModelScope.launch {
      val fetchThemes = plantRepository.fetchThemes()
      _viewState.update { it.copy(plantThemes = fetchThemes) }
    }
  }

  private fun fetchHomeGardenThemes() {
    viewModelScope.launch {
      val fetchThemes = plantRepository.fetchGarden()
      _viewState.update { it.copy(homeGardenItems = fetchThemes) }
    }
  }
}