package com.apripachkin.bloomcompose.data

class InMemoryPlantService : PlantRepository {
  override suspend fun fetchThemes(): List<Data> {
    return sampleData
  }

  override suspend fun fetchGarden(): List<Data> {
    return homeGardenThemes
  }
}