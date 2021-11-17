package com.matthewogtong.recipenotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.matthewogtong.recipenotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: RecipeViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var recipesRV = binding.idRvRecipes
        var addFAB = binding.idFabAddRecipe

        recipesRV.layoutManager = LinearLayoutManager(this)

        val recipeRVAdapter = RecipeRVAdapter(this, this, this)
        recipesRV.adapter = recipeRVAdapter
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(RecipeViewModel::class.java))
        viewModel.allRecipes.observe(this, {list ->
            list?.let {
                recipeRVAdapter.updateList(it)
            }
        })
        addFAB.setOnClickListener {
            val intent = Intent(this@MainActivity)
        }
    }

    override fun onDeleteIconClick(recipe: Recipe) {

    }

    override fun onRecipeClick(recipe: Recipe) {

    }
}