package com.example.recipesapp.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recipesapp.data.Recipes
import com.example.recipesapp.screens.HomeScreen
import com.example.recipesapp.screens.ListRecipesCategoryScreen
import com.example.recipesapp.screens.RecipeDetailScreen
import kotlinx.serialization.internal.throwMissingFieldException


sealed class Screen(val route: String) {

    data object Home : Screen("home")

    data object ListRecipesCategory : Screen("category/{categoryId}/recipes") {
        fun createRoute(categoryId: String): String {
            return "category/$categoryId/recipes"
        }
    }

    data object RecipeDetail : Screen("recipe/{recipeId}") {
        fun createRoute(recipeId: String): String {
            return "recipe/$recipeId"
        }
    }

}

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onCategoryClick = { categoryId: String ->
                    navController.navigate(
                        Screen.ListRecipesCategory.createRoute(categoryId)
                    )
                }
            )
        }

        composable(
            route = Screen.ListRecipesCategory.route
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")

            ListRecipesCategoryScreen(
                categoryId = categoryId,
                onRecipeClick = { recipeId: String ->
                    navController.navigate(
                        Screen.RecipeDetail.createRoute(recipeId)
                    )
                }
            )
        }

        composable(
            route = Screen.RecipeDetail.route
        ) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getString("recipeId")

            val recipe = Recipes.find { it.id == recipeId }
                ?: throw IllegalArgumentException("No se encontró la receta con el ID: $id")

            RecipeDetailScreen(
                recipe = recipe
            )
        }
    }
}