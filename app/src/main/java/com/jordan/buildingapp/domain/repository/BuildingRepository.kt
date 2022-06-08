package com.jordan.buildingapp.domain.repository

import com.jordan.buildingapp.data.remote.BuildingItem
import com.jordan.buildingapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface BuildingRepository {

    suspend fun getBuildItems(page: Int, pageSize: Int): Result<List<BuildingItem>>
}