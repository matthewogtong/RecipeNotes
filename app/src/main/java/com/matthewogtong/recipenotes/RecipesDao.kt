package com.matthewogtong.recipenotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RecipesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recipe: Recipe)

    @Update
    suspend fun update(recipe: Recipe)

    @Delete
    suspend fun delete(recipe: Recipe)

    @Query("SELECT * FROM recipesTable ORDER BY id ASC")
    fun getAllRecipes(): LiveData<List<Recipe>>
}