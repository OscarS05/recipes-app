package com.example.recipesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.recipesapp.R
import com.example.recipesapp.data.Recipe
import com.example.recipesapp.ui.theme.BrownSecondary
import com.example.recipesapp.ui.theme.CaloriesBackground
import com.example.recipesapp.ui.theme.CaloriesContent
import com.example.recipesapp.ui.theme.CardBannerTextColor
import com.example.recipesapp.ui.theme.OrangePrimary

@Composable
fun RecipeDetailScreen(
    recipe: Recipe
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {

        // Hero section
        item {
            RecipeHeroSection(
                data = recipe
            )
        }

        // Recipe information
        item {
            RecipeInfoSection(
                data = recipe
            )
        }

        // Calories
        item {
            CaloriesBadge(
                calories = recipe.calories
            )
        }

        // Ingredients
        item {
            IngredientsSection(
                ingredients = recipe.ingredients
            )
        }

        // Preparation
        item {
            PreparationSection(
                preparation = recipe.preparation
            )
        }
    }
}

@Composable
private fun RecipeHeroSection(
    data: Recipe
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {

        SubcomposeAsyncImage(
            model = data.image,
            contentDescription = data.name,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            loading = {
                RecipeImageFallback()
            },
            error = {
                RecipeImageFallback()
            }
        )

        // Dark gradient for readability
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.75f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(20.dp)
        ) {
            Text(
                text = data.name,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = data.description,
                fontSize = 15.sp,
                color = Color.White
            )
        }
    }
}

@Composable
private fun RecipeInfoSection(
    data: Recipe
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .offset(y = (-8).dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 18.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            RecipeInfoItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = "Duration",
                        tint = OrangePrimary
                    )
                },
                label = "Tiempo",
                value = data.duration
            )

            RecipeInfoItem(
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.chef_hat_24px),
                        contentDescription = "Difficulty",
                        tint = OrangePrimary
                    )
                },
                label = "Nivel",
                value = data.difficulty
            )

            RecipeInfoItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Portions",
                        tint = OrangePrimary
                    )
                },
                label = "Porciones",
                value = data.portions.toString()
            )
        }
    }
}

@Composable
private fun RecipeInfoItem(
    icon: @Composable () -> Unit,
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        icon()

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = label,
            fontSize = 12.sp,
            color = CardBannerTextColor
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = BrownSecondary
        )
    }
}

@Composable
private fun CaloriesBadge(
    calories: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = CaloriesBackground
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.LocalFireDepartment,
                contentDescription = "Calories",
                tint = CaloriesContent
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "$calories kcal por porción",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = CaloriesContent
            )
        }
    }
}

@Composable
private fun IngredientsSection(
    ingredients: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {

        Text(
            text = "Ingredientes",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = BrownSecondary
        )

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ingredients.forEach { ingredient ->

                    Row(
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = "•",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = OrangePrimary
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = ingredient,
                            fontSize = 15.sp,
                            color = CardBannerTextColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PreparationSection(
    preparation: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {

        Text(
            text = "Preparación",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = BrownSecondary
        )

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            preparation.forEachIndexed { index, step ->

                Row(
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "${index + 1}.",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = OrangePrimary,
                        modifier = Modifier.width(28.dp)
                    )

                    Text(
                        text = step,
                        fontSize = 15.sp,
                        color = CardBannerTextColor
                    )
                }
            }
        }
    }
}