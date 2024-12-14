package com.example.week5assignment

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.week5assignment.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Receiving data
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")
        val country = intent.getStringExtra("country")
        val city = intent.getStringExtra("city")

        // Displaying data
        findViewById<TextView>(R.id.textViewWelcome).text = "Welcome $name"
        findViewById<TextView>(R.id.textViewEmail).text = "Email: $email"
        findViewById<TextView>(R.id.textViewGender).text = "Gender: $gender"
        findViewById<TextView>(R.id.textViewCountry).text = "Country: $country"
        findViewById<TextView>(R.id.textViewCity).text = "City: $city"
    }
}
