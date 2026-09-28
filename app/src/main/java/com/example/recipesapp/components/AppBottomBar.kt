package com.example.recipesapp.components

import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.recipesapp.navigation.Screen
import com.example.recipesapp.ui.theme.ColorIconNotSelected
import com.example.recipesapp.ui.theme.ColorUnderIcon
import com.example.recipesapp.ui.theme.OrangePrimary


@Composable
fun AppBottomBar(
    navController: NavHostController
) {
    NavigationBar() {
        NavigationBarItem(
            selected = true,
            onClick = {
                navController.navigate(Screen.Home.route)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = OrangePrimary
                )
            },
            label = {
                Text(
                    text = "Home",
                    color = OrangePrimary
                )
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorites",
                    tint = ColorIconNotSelected
                )
            }
        )
    }
}