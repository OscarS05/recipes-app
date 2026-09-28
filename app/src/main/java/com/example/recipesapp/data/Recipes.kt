package com.example.recipesapp.data

enum class RecipesDifficulty(val text: String) {
    HIGH("Difícil"),
    MEDIUM("Medio"),
    LOW("Bajo"),
}

data class Recipe(
    val id: String,
    val categoryId: String,
    val description: String,
    val name: String,
    val duration: String,
    val difficulty: String,
    val image: String?,
    val portions: Int,
    val calories: Int,
    val ingredients: List<String>,
    val preparation: List<String>,
)

val Recipes: List<Recipe> = listOf(

    // Entradas
    Recipe(
        "1",
        "1",
        "Pan tostado con tomate fresco, albahaca y aceite de oliva.",
        "Bruschettas de tomate y albahaca",
        "15 min",
        RecipesDifficulty.LOW.text,
        null,
        4,
        220,
        listOf(
            "4 slices of bread",
            "2 tomatoes",
            "Fresh basil",
            "1 garlic clove",
            "2 tbsp olive oil",
            "Salt and pepper"
        ),
        listOf(
            "Toast the bread.",
            "Dice the tomatoes and mix with basil and olive oil.",
            "Rub garlic over the toast.",
            "Top with the tomato mixture and season."
        )
    ),
    Recipe(
        "2",
        "1",
        "Croquetas crujientes rellenas de jamón y queso fundido.",
        "Croquetas de jamón y queso",
        "30 min",
        RecipesDifficulty.MEDIUM.text,
        null,
        4,
        310,
        listOf(
            "150 g ham",
            "150 g cheese",
            "2 tbsp flour",
            "250 ml milk",
            "1 tbsp butter",
            "1 egg",
            "Breadcrumbs",
            "Salt and pepper",
            "Oil for frying"
        ),
        listOf(
            "Make a thick béchamel with butter, flour, and milk.",
            "Add diced ham and cheese.",
            "Chill the mixture until firm.",
            "Shape croquettes and coat with egg and breadcrumbs.",
            "Fry until golden."
        )
    ),
    Recipe(
        "3",
        "1",
        "Champiñones salteados con ajo, aceite de oliva y perejil.",
        "Champiñones al ajillo",
        "20 min",
        RecipesDifficulty.LOW.text,
        null,
        4,
        180,
        listOf(
            "400 g mushrooms",
            "3 garlic cloves",
            "2 tbsp olive oil",
            "Fresh parsley",
            "Salt and pepper"
        ),
        listOf(
            "Slice the mushrooms.",
            "Sauté garlic in olive oil.",
            "Add mushrooms and cook until tender.",
            "Season and finish with parsley."
        )
    ),
    Recipe(
        "4",
        "1",
        "Empanadas horneadas rellenas de carne sazonada y verduras.",
        "Empanadas de carne",
        "45 min",
        RecipesDifficulty.MEDIUM.text,
        null,
        6,
        350,
        listOf(
            "500 g ground beef",
            "12 empanada dough discs",
            "1 onion",
            "1 tomato",
            "1 garlic clove",
            "1 tsp cumin",
            "1 egg",
            "Salt and pepper"
        ),
        listOf(
            "Cook the beef with onion, tomato, and garlic.",
            "Season with cumin, salt, and pepper.",
            "Fill the dough discs and seal the edges.",
            "Brush with beaten egg.",
            "Bake until golden."
        )
    ),

    // Platos fuertes
    Recipe(
        "5",
        "2",
        "Pasta cremosa con pollo, parmesano y salsa Alfredo.",
        "Pasta Alfredo con pollo",
        "30 min",
        RecipesDifficulty.MEDIUM.text,
        "https://images.unsplash.com/photo-1626844131082-256783844137?auto=format&fit=crop&w=800&q=80",
        4,
        620,
        listOf(
            "400 g fettuccine",
            "400 g chicken breast",
            "200 ml heavy cream",
            "100 g Parmesan cheese",
            "2 garlic cloves",
            "2 tbsp butter",
            "Salt and pepper"
        ),
        listOf(
            "Cook the pasta until al dente.",
            "Season and cook the chicken, then slice it.",
            "Sauté garlic in butter and add cream.",
            "Stir in Parmesan until smooth.",
            "Mix with pasta and chicken."
        )
    ),
    Recipe(
        "6",
        "2",
        "Tacos de carne asada con verduras frescas y un toque de lima.",
        "Tacos de carne asada",
        "25 min",
        RecipesDifficulty.MEDIUM.text,
        "https://images.unsplash.com/photo-1551504734-5ee1c4a1479b?auto=format&fit=crop&w=800&q=80",
        4,
        480,
        listOf(
            "500 g beef steak",
            "8 corn tortillas",
            "1 onion",
            "1 tomato",
            "Fresh cilantro",
            "1 lime",
            "1 tsp cumin",
            "Salt and pepper"
        ),
        listOf(
            "Season the beef with cumin, salt, and pepper.",
            "Grill the beef until cooked.",
            "Slice the beef into strips.",
            "Warm the tortillas.",
            "Fill with beef, onion, tomato, cilantro, and lime."
        )
    ),
    Recipe(
        "7",
        "2",
        "Salmón a la parrilla acompañado de verduras frescas y limón.",
        "Salmón a la parrilla con verduras",
        "25 min",
        RecipesDifficulty.MEDIUM.text,
        null,
        4,
        430,
        listOf(
            "4 salmon fillets",
            "2 zucchini",
            "1 bell pepper",
            "1 lemon",
            "2 tbsp olive oil",
            "Garlic powder",
            "Salt and pepper"
        ),
        listOf(
            "Season the salmon with lemon, garlic, salt, and pepper.",
            "Slice the vegetables.",
            "Grill the salmon until cooked.",
            "Grill the vegetables with olive oil.",
            "Serve together with lemon."
        )
    ),
    Recipe(
        "8",
        "2",
        "Risotto cremoso de arroz Arborio con champiñones y parmesano.",
        "Risotto de champiñones",
        "40 min",
        RecipesDifficulty.HIGH.text,
        "https://images.unsplash.com/photo-1476124369491-e7addf5db371?auto=format&fit=crop&w=800&q=80",
        4,
        510,
        listOf(
            "300 g Arborio rice",
            "250 g mushrooms",
            "1 onion",
            "1 l vegetable broth",
            "100 ml white wine",
            "50 g Parmesan cheese",
            "2 tbsp butter",
            "2 tbsp olive oil",
            "Salt and pepper"
        ),
        listOf(
            "Sauté onion and mushrooms in olive oil.",
            "Add rice and toast for 2 minutes.",
            "Pour in the wine and let it reduce.",
            "Add broth gradually while stirring.",
            "Finish with butter and Parmesan."
        )
    ),

    // Postres
    Recipe(
        "9",
        "3",
        "Postre italiano cremoso con café, mascarpone y cacao.",
        "Tiramisú clásico",
        "35 min",
        RecipesDifficulty.MEDIUM.text,
        null,
        6,
        420,
        listOf(
            "250 g mascarpone",
            "3 eggs",
            "80 g sugar",
            "200 g ladyfingers",
            "250 ml coffee",
            "Cocoa powder"
        ),
        listOf(
            "Whisk egg yolks with sugar and mascarpone.",
            "Beat the egg whites and fold them in.",
            "Dip ladyfingers in coffee.",
            "Layer ladyfingers and cream.",
            "Dust with cocoa and chill."
        )
    ),
    Recipe(
        "10",
        "3",
        "Cheesecake cremoso con una base crujiente y frutos rojos.",
        "Cheesecake de frutos rojos",
        "60 min",
        RecipesDifficulty.HIGH.text,
        null,
        8,
        460,
        listOf(
            "250 g digestive biscuits",
            "100 g butter",
            "500 g cream cheese",
            "150 g sugar",
            "2 eggs",
            "1 tsp vanilla",
            "200 g mixed berries"
        ),
        listOf(
            "Crush the biscuits and mix with melted butter.",
            "Press into a baking pan.",
            "Beat cream cheese, sugar, eggs, and vanilla.",
            "Pour over the crust and bake.",
            "Cool and top with berries."
        )
    ),
    Recipe(
        "11",
        "3",
        "Brownies intensos de chocolate con una textura suave y húmeda.",
        "Brownies de chocolate",
        "40 min",
        RecipesDifficulty.LOW.text,
        null,
        9,
        380,
        listOf(
            "200 g dark chocolate",
            "150 g butter",
            "180 g sugar",
            "3 eggs",
            "100 g flour",
            "30 g cocoa powder",
            "1 tsp vanilla"
        ),
        listOf(
            "Melt the chocolate and butter.",
            "Whisk in sugar, eggs, and vanilla.",
            "Fold in flour and cocoa.",
            "Pour into a lined pan.",
            "Bake until just set and cool."
        )
    ),
    Recipe(
        "12",
        "3",
        "Flan suave y cremoso cubierto con caramelo dorado.",
        "Flan de caramelo",
        "50 min",
        RecipesDifficulty.MEDIUM.text,
        null,
        6,
        290,
        listOf(
            "500 ml milk",
            "4 eggs",
            "120 g sugar",
            "1 tsp vanilla",
            "80 g sugar for caramel"
        ),
        listOf(
            "Melt sugar until golden and pour into a mold.",
            "Whisk milk, eggs, sugar, and vanilla.",
            "Pour into the caramel-coated mold.",
            "Bake in a water bath.",
            "Cool and refrigerate before serving."
        )
    ),

    // Bebidas
    Recipe(
        "13",
        "4",
        "Bebida refrescante de limón, hierbabuena, azúcar y hielo.",
        "Limonada de hierbabuena",
        "10 min",
        RecipesDifficulty.LOW.text,
        null,
        4,
        90,
        listOf(
            "4 lemons",
            "1 l water",
            "80 g sugar",
            "Fresh mint",
            "Ice"
        ),
        listOf(
            "Juice the lemons.",
            "Mix lemon juice with water and sugar.",
            "Add fresh mint and ice.",
            "Stir and serve cold."
        )
    ),
    Recipe(
        "14",
        "4",
        "Batido cremoso y refrescante de fresa, banana y leche.",
        "Batido de fresa y banana",
        "10 min",
        RecipesDifficulty.LOW.text,
        null,
        2,
        240,
        listOf(
            "1 banana",
            "200 g strawberries",
            "250 ml milk",
            "1 tbsp honey",
            "Ice"
        ),
        listOf(
            "Add all ingredients to a blender.",
            "Blend until smooth.",
            "Serve immediately."
        )
    ),
    Recipe(
        "15",
        "4",
        "Bebida caliente y cremosa de chocolate negro, leche y vainilla.",
        "Chocolate caliente",
        "15 min",
        RecipesDifficulty.LOW.text,
        null,
        2,
        280,
        listOf(
            "500 ml milk",
            "60 g dark chocolate",
            "1 tbsp sugar",
            "1 tsp cocoa powder",
            "1 tsp vanilla"
        ),
        listOf(
            "Heat the milk over medium heat.",
            "Add chocolate, cocoa, and sugar.",
            "Stir until completely melted.",
            "Add vanilla and serve hot."
        )
    ),
    Recipe(
        "16",
        "4",
        "Bebida refrescante de frutos rojos, lima, hierbabuena y agua con gas.",
        "Mojito de frutos rojos",
        "15 min",
        RecipesDifficulty.MEDIUM.text,
        null,
        2,
        180,
        listOf(
            "100 g mixed berries",
            "1 lime",
            "Fresh mint",
            "2 tsp sugar",
            "250 ml sparkling water",
            "Ice"
        ),
        listOf(
            "Muddle berries, lime, mint, and sugar.",
            "Fill glasses with ice.",
            "Add the berry mixture.",
            "Top with sparkling water and stir."
        )
    )
)