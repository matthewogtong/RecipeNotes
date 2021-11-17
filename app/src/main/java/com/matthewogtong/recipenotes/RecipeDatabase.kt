package com.matthewogtong.recipenotes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Recipe::class), version = 1, exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {

    abstract fun getRecipesDao(): RecipesDao

    companion object {

        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        fun getDatabase(context: Context): RecipeDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeDatabase::class.java,
                    "recipe_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }
}