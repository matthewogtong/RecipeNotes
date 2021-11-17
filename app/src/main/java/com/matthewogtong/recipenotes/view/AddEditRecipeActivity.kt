package com.matthewogtong.recipenotes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.matthewogtong.recipenotes.R
import com.matthewogtong.recipenotes.Recipe
import com.matthewogtong.recipenotes.databinding.ActivityAddEditRecipeBinding
import com.matthewogtong.recipenotes.viewmodel.RecipeViewModel
import java.text.SimpleDateFormat
import java.util.*

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

        val recipeType = intent.getStringExtra("recipeType")
        if(recipeType.equals("Edit")) {
            val recipeTitle = intent.getStringExtra("")
            val recipeDescription = intent.getStringExtra("")
            recipeID = intent.getIntExtra("", -1)
            addUpdateBtn.text = "Update Recipe"
            recipeTitleEdit.setText(recipeTitle)
            recipeDescriptionEdit.setText(recipeDescription)
        } else {
            addUpdateBtn.text = "Save Recipe"
        }

        addUpdateBtn.setOnClickListener {
            val recipeTitle = recipeTitleEdit.text.toString()
            val recipeDescription = recipeDescriptionEdit.text.toString()

            if(recipeType.equals("Edit")) {
                if (recipeType != null) {
                    if(recipeType.isNotEmpty() && recipeDescription.isNotEmpty()) {
                        val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                        val currentDate: String = sdf.format(Date())
                        val updateRecipe = Recipe(recipeTitle, recipeDescription, currentDate)
                        updateRecipe.id = recipeID
                        viewModel.updateRecipe(updateRecipe)
                        Toast.makeText(this, "Recipe Updated", Toast.LENGTH_LONG).show()
                    }
                } else {
                    if(recipeTitle.isNotEmpty() && recipeDescription.isNotEmpty()) {
                        val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                        val currentDate: String = sdf.format(Date())
                        viewModel.addRecipe(Recipe(recipeTitle, recipeDescription, currentDate))
                        Toast.makeText(this, "Recipe Added..", Toast.LENGTH_LONG).show()
                    }
                }
                startActivity(Intent(applicationContext, MainActivity::class.java))
                this.finish()
            }
        }


    }
}