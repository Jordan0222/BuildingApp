package com.jordan.buildingapp.data.repository

import com.jordan.buildingapp.data.remote.BuildingApi
import com.jordan.buildingapp.data.remote.BuildingItem
import com.jordan.buildingapp.domain.repository.BuildingRepository
import java.lang.Exception

class BuildingRepositoryImpl(
    private val buildingApi: BuildingApi
): BuildingRepository {
    override suspend fun getBuildItems(page: Int, pageSize: Int): Result<List<BuildingItem>> {
        return try {
            val response = buildingApi.getBuildingItems()
            val buildingItems = response.DataList
            val startingIndex = page * pageSize
            if (startingIndex + pageSize <= buildingItems.size) {
                Result.success(
                    buildingItems.slice(startingIndex until startingIndex + pageSize)
                )
            } else Result.success(emptyList())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}