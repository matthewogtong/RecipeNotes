package com.matthewogtong.recipenotes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.matthewogtong.recipenotes.R
import com.matthewogtong.recipenotes.databinding.ActivityAddEditRecipeBinding
import com.matthewogtong.recipenotes.viewmodel.RecipeViewModel

class AddEditRecipeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddEditRecipeBinding.inflate(layoutInflater) }
    lateinit var viewModel: RecipeViewModel
    var recipeID = -1

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_recipe)

        var recipeTitleEdit = binding.idEditRecipeTitle
        var recipeDescriptionEdit = binding.idEditRecipeDescription
        var addUpdateBtn = binding.idBtnAddUpdate

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(RecipeViewModel::class.java)

        val recipeType = intent.getStringExtra("")


    }
}