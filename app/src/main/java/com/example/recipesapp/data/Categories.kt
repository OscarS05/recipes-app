package com.example.recipesapp.data

import com.example.recipesapp.R

enum class CategoryNames (val text: String) {
    STARTERS("Starters"),
    MAIN("Main courses"),
    DESSERT("Desserts"),
    DRINKS("Drinks")
}

data class Category(
    val id: String,
    val type: String,
    val description: String,
    val image: Int,
    val icon: Int,
    val quantityRecipes: Int
)

val CategoriesList: List<Category> = listOf(
    Category(
        id = "1",
        CategoryNames.STARTERS.text,
        "Light dishes to start the meal",
        R.drawable.starters,
        R.drawable.salad,
        Recipes.count { it.categoryId == "1" }
    ),
    Category(
        id = "2",
        CategoryNames.MAIN.text,
        "Recipes for hearty main dishes",
        R.drawable.main_courses,
        R.drawable.dining,
        Recipes.count { it.categoryId == "2" }
    ),
    Category(
        id = "3",
        CategoryNames.DESSERT.text,
        "Irresistible sweets for a perfect finish",
        R.drawable.desserts,
        R.drawable.cake,
        Recipes.count { it.categoryId == "3" }
    ),
    Category(
        id = "4",
        CategoryNames.DRINKS.text,
        "Refreshing drinks to accompany your meals",
        R.drawable.drinks,
        R.drawable.water,
        Recipes.count { it.categoryId == "4" }
    )
)