package com.example.easy_timesheet.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.easytimesheet.R

class AddLocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_location)

        val locationNameEditText = findViewById<EditText>(R.id.locationName)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val locationName = locationNameEditText.text.toString()
            Toast.makeText(this, "Location saved: $locationName", Toast.LENGTH_SHORT).show()
        }
    }
}
