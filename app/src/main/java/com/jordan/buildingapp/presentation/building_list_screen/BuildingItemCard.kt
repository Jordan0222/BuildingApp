package com.jordan.buildingapp.presentation.building_list_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.jordan.buildingapp.R
import com.jordan.buildingapp.data.remote.BuildingItem
import com.jordan.buildingapp.util.Screen

@Composable
fun BuildingItemCard(
    navController: NavController,
    buildingItem: BuildingItem
) {
    val painter = rememberImagePainter(data = buildingItem.img) {
        crossfade(durationMillis = 1000)
        error(R.drawable.ic_placeholder)
        placeholder(R.drawable.ic_placeholder)
    }

    Box(
        modifier = Modifier
            .clickable {
                navController.navigate(
                    route = Screen.BuildingScreen.route +
                            "?img=${buildingItem.img}" +
                            "&content=${buildingItem.content}" +
                            "&title=${buildingItem.title}"
                )
            }
            .height(300.dp)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color(0xFFE5E8E8),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {}
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(263.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = "Unsplash Image",
                contentScale = ContentScale.Crop
            )
        }
    }
}