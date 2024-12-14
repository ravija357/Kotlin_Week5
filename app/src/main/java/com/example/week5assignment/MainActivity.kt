package com.example.week5assignment

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.week5assignment.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // References
        val name = findViewById<EditText>(R.id.editTextName)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val genderGroup = findViewById<RadioGroup>(R.id.radioGroupGender)
        val countrySpinner = findViewById<Spinner>(R.id.spinnerCountry)
        val cityAutoComplete = findViewById<AutoCompleteTextView>(R.id.autoCompleteCity)
        val checkBoxAgree = findViewById<CheckBox>(R.id.checkBoxAgree)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        // Set Spinner Data
        val countries = arrayOf("India", "USA", "Canada", "UK", "Australia")
        countrySpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countries)

        // Set AutoCompleteTextView Data
        val cities = arrayOf("Mumbai", "New York", "Toronto", "London", "Sydney")
        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cities)
        cityAutoComplete.setAdapter(cityAdapter)

        buttonSubmit.setOnClickListener {
            if (checkBoxAgree.isChecked) {
                // Collecting data
                val selectedGenderId = genderGroup.checkedRadioButtonId
                val gender = findViewById<RadioButton>(selectedGenderId)?.text ?: "Not selected"

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("name", name.text.toString())
                intent.putExtra("email", email.text.toString())
                intent.putExtra("gender", gender)
                intent.putExtra("country", countrySpinner.selectedItem.toString())
                intent.putExtra("city", cityAutoComplete.text.toString())

                startActivity(intent)
            } else {
                Toast.makeText(this, "Please agree to terms and conditions", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
