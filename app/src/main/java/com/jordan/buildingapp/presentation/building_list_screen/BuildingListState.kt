package com.jordan.buildingapp.presentation.building_list_screen

import com.jordan.buildingapp.data.remote.BuildingItem

data class BuildingListState(
    val buildingItems: List<BuildingItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)
