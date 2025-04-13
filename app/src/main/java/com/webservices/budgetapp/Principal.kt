package com.webservices.budgetapp
import com.webservices.budgetapp.Recipe

fun main () {
    val recipe = Recipe()

    recipe.addIngredient("Rice")
    recipe.addIngredient("Chicken")
    recipe.addIngredient("Potatoes")

    println(recipe.getIngredients())
}