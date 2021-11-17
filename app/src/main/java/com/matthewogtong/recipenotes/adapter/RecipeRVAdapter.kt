package com.matthewogtong.recipenotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matthewogtong.recipenotes.databinding.RecipeRvItemBinding

class RecipeRVAdapter(
    val context: Context,
    private val recipeClickInterface: RecipeClickInterface,
    private val recipeClickDeleteInterface: RecipeClickDeleteInterface
) : RecyclerView.Adapter<RecipeRVAdapter.ViewHolder>(){

    private val allRecipes = ArrayList<Recipe>()

    private lateinit var binding: RecipeRvItemBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeTV = binding.idTvRecipeTitle
        val timeTV = binding.idTvRecipeTimeStamp
        val deleteIV = binding.idIvDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recipe_rv_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.recipeTV.text = allRecipes.get(position).recipeTitle
        holder.timeTV.text = "Last Updated : " +allRecipes[position].timeStamp

        holder.deleteIV.setOnClickListener {
            recipeClickDeleteInterface.onDeleteIconClick(allRecipes[position])
        }

        holder.itemView.setOnClickListener {
            recipeClickInterface.onRecipeClick(allRecipes[position])
        }
    }

    override fun getItemCount(): Int {
        return allRecipes.size
    }

    fun updateList(newList : List<Recipe>) {
        allRecipes.clear()
        allRecipes.addAll(newList)
        notifyDataSetChanged()
    }
}

interface RecipeClickDeleteInterface {
    fun onDeleteIconClick(recipe: Recipe)
}

interface RecipeClickInterface {
    fun onRecipeClick(recipe: Recipe)
}