package com.example.recipesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.recipesapp.components.AppBottomBar
import com.example.recipesapp.components.AppTopBar
import com.example.recipesapp.navigation.AppNavigation
import com.example.recipesapp.ui.theme.RecipesAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            RecipesAPPTheme {
                RecipesApp()
            }
        }
    }
}

@Composable
fun RecipesApp () {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            AppTopBar()
        },
        bottomBar = {
            AppBottomBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        AppNavigation(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}