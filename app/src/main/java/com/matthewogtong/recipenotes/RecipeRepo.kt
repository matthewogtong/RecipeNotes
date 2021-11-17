package com.matthewogtong.recipenotes

import androidx.lifecycle.LiveData

class RecipeRepo(private val recipesDao: RecipesDao) {

    val allRecipes: LiveData<List<Recipe>> = recipesDao.getAllRecipes()

    suspend fun insert(recipe: Recipe) {
        recipesDao.insert(recipe)
    }

    suspend fun delete(recipe: Recipe) {
        recipesDao.delete(recipe)
    }

    suspend fun update(recipe: Recipe) {
        recipesDao.update(recipe)
    }

}