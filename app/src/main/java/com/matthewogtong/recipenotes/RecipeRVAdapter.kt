package com.matthewogtong.recipenotes

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matthewogtong.recipenotes.databinding.RecipeRvItemBinding

class RecipeRVAdapter(
    val context: Context,
    val recipeClickInterface: RecipeClickInterface,
    val recipeClickDeleteInterface: RecipeClickDeleteInterface
) : RecyclerView.Adapter<RecipeRVAdapter.ViewHolder>(){

    private val allRecipes = ArrayList<Recipe>()

    private lateinit var binding: RecipeRvItemBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeTV = binding.idTvRecipeTitle
        val timeTV = binding.idTvRecipeTimeStamp
        val deleteIV = binding.idIvDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

interface RecipeClickDeleteInterface {
    fun onDeleteIconClick(recipe: Recipe)
}

interface RecipeClickInterface {
    fun onRecipeClick(recipe: Recipe)
}