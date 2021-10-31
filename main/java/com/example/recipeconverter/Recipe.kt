package com.example.recipeconverter

import java.util.*
import java.util.Scanner

class Recipe() {

    var oldServings: Float = 0F
    var newServings: Float = 0F
    var ingredient: String? = null
    var measurement: Float = 0F
    var measurementType: Int = 0

    val measurementsMap = mapOf(1 to "cup", 2 to "half-cup", 3 to "third-cup", 4 to "quarter-cup", 5 to "tablespoon", 6 to "teaspoon")

    fun getIngredient(): Int {
        val reader = Scanner(System.`in`)
        print("Enter the servings stated in the original recipe: ")
        oldServings = reader.nextFloat()
        print("Enter the amount of servings you want to make: ")
        newServings = reader.nextFloat()
        print("Enter the ingredient: ")
        ingredient = readLine()
        print("Enter the measurement: ")
        measurement = reader.nextFloat()
        println("Enter the measurement type number: ")
        println("1: Cups")
        println("2: Half-Cups")
        println("3: Third-Cups")
        println("4: Quarter Cups")
        println("5: Tablespoons")
        println("6: Teaspoons")
        measurementType = reader.nextInt()

        return measurementType
    }
}