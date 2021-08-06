package com.apripachkin.bloomcompose.data

import kotlinx.coroutines.delay

class InMemoryPlantService : PlantRepository {
  override suspend fun fetchThemes(): List<Data> {
    delay(5_000)
    return sampleData
  }

  override suspend fun fetchGarden(): List<Data> {
    return homeGardenThemes
  }
}