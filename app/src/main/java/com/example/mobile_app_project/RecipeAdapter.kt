package com.example.mobile_app_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_app_project.Recipe
import com.example.mobile_app_project.R

class RecipeAdapter(
    private val recipes: List<Recipe>,
    private val onItemClicked: (Recipe) -> Unit,
    private val onActionClicked: (Recipe, String) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    // Inner class to hold the item view
    inner class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val recipeImage: ImageView = view.findViewById(R.id.imageRecipe)
        private val recipeName: TextView = view.findViewById(R.id.textRecipeName)
        private val likeButton: Button = view.findViewById(R.id.btnLike)
        private val shareButton: Button = view.findViewById(R.id.btnShare)

        fun bind(recipe: Recipe) {
            recipeImage.setImageResource(recipe.imageRes)
            recipeName.text = recipe.name

            // Set up click listeners
            itemView.setOnClickListener { onItemClicked(recipe) }
            likeButton.setOnClickListener { onActionClicked(recipe, "Like") }
            shareButton.setOnClickListener { onActionClicked(recipe, "Share") }
        }
    }

    // Inflate the layout for an item and create its ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_layout, parent, false)
        return RecipeViewHolder(itemView)
    }

    // Bind data to the ViewHolder for the given position
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    // Return the total number of items
    override fun getItemCount(): Int {
        return recipes.size
    }
}
