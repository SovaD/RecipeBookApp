package com.sova.recipeapp.network


import kotlinx.coroutines.Deferred
import com.sova.recipeapp.model.CategoryResponse
import com.sova.recipeapp.model.FilterResponse
import com.sova.recipeapp.model.Recipe
import com.sova.recipeapp.model.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("api/json/v1/1/random.php")
    fun getRandomRecipe(): Deferred<RecipeResponse>

    @GET("api/json/v1/1/categories.php")
    fun getCategoriesRecipe(): Deferred<CategoryResponse>

    @GET("api/json/v1/1/filter.php")
    fun getRecipeByCategory(
        @Query("c") category: String?
    ): Deferred<FilterResponse>

    @GET("api/json/v1/1/search.php")
    fun searchRecipe(
        @Query("s") search: String?
    ): Deferred<FilterResponse>

    @GET("api/json/v1/1/lookup.php")
    fun getDetailRecipe(
        @Query("i") idMeal: String?
    ): Deferred<RecipeResponse>
}