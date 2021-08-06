package com.apripachkin.bloomcompose.data

interface PlantRepository {
  suspend fun fetchThemes(): List<Data>
  suspend fun fetchGarden(): List<Data>
}