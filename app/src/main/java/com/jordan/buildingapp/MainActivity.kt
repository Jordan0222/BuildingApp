package com.jordan.buildingapp

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jordan.buildingapp.presentation.building_list_screen.BuildingListScreen
import com.jordan.buildingapp.presentation.building_screen.BuildingScreen
import com.jordan.buildingapp.ui.theme.BuildingAppTheme
import com.jordan.buildingapp.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuildingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavigationHost()
                }
            }
        }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.BuildingListScreen.route
    ) {
        composable(
            route = Screen.BuildingListScreen.route
        ) {
            BuildingListScreen(navController = navController)
        }

        composable(
            route = Screen.BuildingScreen.route +
                    "?img={img}&content={content}&title={title}",
            arguments = listOf(
                navArgument("img") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("content") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("title") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            BuildingScreen(
                navController = navController,
                orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            )
        }
    }
}