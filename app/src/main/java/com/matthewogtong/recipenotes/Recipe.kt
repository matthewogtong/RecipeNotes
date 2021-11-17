package com.matthewogtong.recipenotes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipesTable")
class Recipe(
    @ColumnInfo(name = "title") val recipeTitle: String,
    @ColumnInfo(name = "description") val recipeDescription: String,
    @ColumnInfo(name = "timestamp") val timeStamp: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}