package com.jordan.buildingapp.util


sealed class Screen(val route: String) {
    object BuildingListScreen: Screen("building_list_screen")
    object BuildingScreen: Screen("building_screen")
}