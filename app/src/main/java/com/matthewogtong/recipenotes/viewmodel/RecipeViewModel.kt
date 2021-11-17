package com.matthewogtong.recipenotes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.matthewogtong.recipenotes.Recipe
import com.matthewogtong.recipenotes.RecipeDatabase
import com.matthewogtong.recipenotes.RecipeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    val allRecipes: LiveData<List<Recipe>>
    val repository: RecipeRepo

    init {
        val dao = RecipeDatabase.getDatabase(application).getRecipesDao()
        repository = RecipeRepo(dao)
        allRecipes = repository.allRecipes
    }

    fun deleteRecipe(recipe: Recipe) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(recipe)
    }

    fun updateRecipe(recipe: Recipe) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(recipe)
    }

    fun addRecipe(recipe: Recipe) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(recipe)
    }

}