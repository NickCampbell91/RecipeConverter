package com.example.recipeconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convert_button = findViewById<Button>(R.id.convert)



        val spinner: Spinner = findViewById(R.id.measurementType)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.measurementType_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                item = parent.getItemAtPosition(pos)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }

//        convert_button.setOnClickListener {convert()}



        fun convertToCups(a: Float, type: Spinner): Float{
            val recipe = Recipe()
            var b: Float = 0F

            if (type == "Cups"){
                b = a
            }

            if (type == 2){
                b = a / 2
            }

            if (type == 3){
                b = a / 3
            }

            if (type == 4){
                b = a / 4
            }

            if (type == 5){
                b = a / 16
            }

            if (type == 6){
                b = a / 48
            }

            return b
        }

        fun convert(type: Spinner){
            val recipe = Recipe()
            val simplify = Simplify()
            var newMeasurementInCups: Float = 0F

    //        val type = findViewById<Spinner>(R.id.measurementType)
    //        type.onItemSelectedListener = this
            val newServings = findViewById<EditText>(R.id.newServings)
            val originalServings = findViewById<EditText>(R.id.originalServings)
            val ingredient = findViewById<EditText>(R.id.ingredient)
            val measurement = findViewById<EditText>(R.id.measurement)
            val output = findViewById<TextView>(R.id.output)

            var multiplier: Float = (newServings.text.toString().toFloat() / originalServings.text.toString().toFloat())

    //    println("The multiplier is: $multiplier")

            var newMeasurement = multiplier * measurement.text.toString().toFloat()

    //    println("The new measurement is: $newMeasurement")

            newMeasurementInCups = convertToCups(newMeasurement, type)

    //    println("The new measurement in cups is: $newMeasurementInCups")

            simplify.simplifyMeasurement(newMeasurementInCups)

    //    println("The number of cups is: ${simplify.cups}")

    //    print("Number of Cups: ${simplify.quarterCups}")
    //    print(recipe.measurementsMap[recipe.measurementType])

            output.text = ("Add ${simplify.cups} cup(s) " +
                    "${simplify.halfCups}/2 cup, " +
                    "${simplify.thirdCups}/3 cup(s), " +
                    "${simplify.quarterCups}/4 cup(s), " +
                    "${simplify.tablespoons} tablespoon(s), " +
                    "${simplify.teaspoons} teaspoons(s) of ${ingredient}")

    //    println("Remaining: ${simplify.a}")
        }

        convert_button.setOnClickListener {convert(item)}
}