package za.ac.iie.mealplan

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//identifies variables and ids in order for the application to operate effectively
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val edtTime = findViewById<EditText>(R.id.edtTime)
        val txtSuggest = findViewById<TextView>(R.id.txtSuggest)
        val txtTime2 = findViewById<TextView>(R.id.txtTime2)

//this part will allow the user to be able to reset or clear outputs that are displayed
        btnClear.setOnClickListener {
            edtTime.text.clear()
            txtSuggest.text = ""
        }

//this part allows the user to input certain times of the day and displays the output
        btnSuggest.setOnClickListener {
            val Time = edtTime.text.toString()
            var mealSuggestion = ""



            if (Time == "morning") {
                mealSuggestion = "Breakfast: Fruit salad and plain yoghurt"
            } else if (Time == "mid morning") {
                mealSuggestion = "Morning snack: Smoothie"
            } else if (Time == "afternoon") {
                mealSuggestion = "Lunch: Chicken sandwhich and coca cola"
            } else if (Time == "mid afternoon") {
                mealSuggestion = "Snack: Chocolate bar and potato chips"
            } else if (Time == "dinner") {
                mealSuggestion = "Dinner: Ox-tail and mashed potatoes"
            } else if (Time == "after dinner snack") {
                mealSuggestion = "Dessert: Tiramisu"
            } else {
                mealSuggestion ="Invalid input, please enter a valid time "
            }

            txtSuggest.text = mealSuggestion
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}