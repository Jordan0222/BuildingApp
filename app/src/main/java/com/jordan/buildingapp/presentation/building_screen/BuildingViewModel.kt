package com.jordan.buildingapp.presentation.building_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BuildingViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var buildingState by mutableStateOf(BuildingState())

    init {
        val img = savedStateHandle.get<String>("img").toString()
        val content = savedStateHandle.get<String>("content").toString()
        val title = savedStateHandle.get<String>("title").toString()

        buildingState = buildingState.copy(
            img = img,
            content = content,
            title = title
        )
    }
}