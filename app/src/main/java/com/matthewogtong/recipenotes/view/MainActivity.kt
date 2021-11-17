package com.matthewogtong.recipenotes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.matthewogtong.recipenotes.Recipe
import com.matthewogtong.recipenotes.RecipeClickDeleteInterface
import com.matthewogtong.recipenotes.RecipeClickInterface
import com.matthewogtong.recipenotes.RecipeRVAdapter
import com.matthewogtong.recipenotes.databinding.ActivityMainBinding
import com.matthewogtong.recipenotes.viewmodel.RecipeViewModel

class MainActivity : AppCompatActivity(), RecipeClickDeleteInterface, RecipeClickInterface {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    lateinit var viewModel: RecipeViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var recipesRV = binding.idRvRecipes
        var addFAB = binding.idFabAddRecipe
        recipesRV.layoutManager = LinearLayoutManager(this)

        val recipeRVAdapter = RecipeRVAdapter(this, this, this)
        recipesRV.adapter = recipeRVAdapter
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))[RecipeViewModel::class.java]
        viewModel.allRecipes.observe(this, Observer { list ->
            list?.let {
                recipeRVAdapter.updateList(it)
            }
        })
        addFAB.setOnClickListener {
            val intent = Intent(this@MainActivity, AddEditRecipeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDeleteIconClick(recipe: Recipe) {
        viewModel.deleteRecipe(recipe)
        Toast.makeText(this, "${recipe.recipeTitle} Deleted", Toast.LENGTH_LONG).show()
    }

    override fun onRecipeClick(recipe: Recipe) {
        val intent = Intent(this@MainActivity, AddEditRecipeActivity::class.java)
        intent.putExtra("recipeType", "Edit")
        intent.putExtra("recipeTitle", recipe.recipeTitle)
        intent.putExtra("recipeDescription", recipe.recipeDescription)
        intent.putExtra("recipeID", recipe.id)
        startActivity(intent)
        this.finish()
    }
}