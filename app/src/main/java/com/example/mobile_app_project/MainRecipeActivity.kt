package com.example.mobile_app_project

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_app_project.Recipe
import com.example.mobile_app_project.R

class MainRecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val recipes = getRecipeList()
        val adapter = createRecipeAdapter(recipes)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainRecipeActivity)
            this.adapter = adapter
        }
    }

    private fun getRecipeList(): List<Recipe> {
        return listOf(
            Recipe(1, "Paella", R.drawable.paella, "Spanish rice with seafood."),
            Recipe(2, "Lasagna", R.drawable.lasagna, "Layered pasta with savory fillings."),
            Recipe(3, "Enchiladas", R.drawable.enchiladas, "Rolled tortillas with spicy sauce.")
        )
    }

    private fun createRecipeAdapter(recipes: List<Recipe>): RecipeAdapter {
        return RecipeAdapter(
            recipes,
            onItemClicked = { recipe ->
                showToast("Clicked: ${recipe.name} (ID: ${recipe.id})")
            },
            onActionClicked = { recipe, action ->
                showToast("$action on: ${recipe.name} (ID: ${recipe.id})")
            }
        )
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
