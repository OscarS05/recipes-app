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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.recipesapp.R
import com.example.recipesapp.data.Recipe
import com.example.recipesapp.data.Recipes
import com.example.recipesapp.ui.theme.BrownSecondary
import com.example.recipesapp.ui.theme.CardBadgeTextColor
import com.example.recipesapp.ui.theme.CardBannerTextColor
import com.example.recipesapp.ui.theme.ColorIconNotSelected
import com.example.recipesapp.ui.theme.OrangePrimary
import com.example.recipesapp.ui.theme.RecipeCardBackground
import com.example.recipesapp.ui.theme.TimeBadgeBackground
import com.example.recipesapp.ui.theme.TimeBadgeText

@Composable
fun ListRecipesCategoryScreen(
    categoryId: String?,
    onRecipeClick: (String) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 346.dp),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(Recipes.filter { it.categoryId == categoryId }) { recipe ->
            RecipeCard(data = recipe, onRecipeClick)
        }
    }
}

@Composable
fun RecipeCard(
    data: Recipe,
    onRecipeClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .width(346.dp)
            .height(256.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(22.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        onClick = {
            onRecipeClick(data.id)
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
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

            // Duration badge
            Card(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(12.dp),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = TimeBadgeBackground.copy(alpha = 0.8f)
                )
            ) {
                Text(
                    text = data.duration,
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 2.dp
                    ),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = TimeBadgeText
                )
            }

            // Bottom information
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.25f)
                    .align(Alignment.BottomCenter),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(
                    bottomStart = 22.dp,
                    bottomEnd = 22.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 10.dp
                        ),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = data.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = BrownSecondary
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccessTime,
                                contentDescription = "Duration",
                                modifier = Modifier.size(18.dp),
                                tint = ColorIconNotSelected
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(
                                text = data.duration,
                                fontSize = 14.sp,
                                color = ColorIconNotSelected
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.chef_hat_24px),
                                contentDescription = "Difficulty",
                                modifier = Modifier.size(18.dp),
                                tint = ColorIconNotSelected
                            )

                            Spacer(modifier = Modifier.width(6.dp))

                            Text(
                                text = data.difficulty,
                                fontSize = 14.sp,
                                color = ColorIconNotSelected
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RecipeImageFallback() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(RecipeCardBackground),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.dining),
            contentDescription = "Recipe",
            modifier = Modifier.size(64.dp),
            tint = OrangePrimary
        )
    }
}