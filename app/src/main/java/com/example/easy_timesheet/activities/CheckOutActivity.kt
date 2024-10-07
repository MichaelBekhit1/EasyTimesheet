package com.yourpackage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.easy_timesheet.data.entities.Location
import com.example.easytimesheet.R

class CheckOutActivity : AppCompatActivity() {

    private lateinit var currentLocationTextView: TextView
    private lateinit var locationNameTextView: TextView
    private lateinit var checkOutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        currentLocationTextView = findViewById(R.id.currentLocationTextView)
        locationNameTextView = findViewById(R.id.locationNameTextView)
        checkOutButton = findViewById(R.id.checkOutButton)

        val currentLocation = getCurrentCheckedInLocation()

        if (currentLocation != null) {
            locationNameTextView.text = currentLocation.name
            checkOutButton.setOnClickListener {
                checkOutFromLocation(currentLocation)
            }
        } else {
            currentLocationTextView.text =
                getString(R.string.you_are_not_currently_checked_in_at_any_location)
            checkOutButton.isEnabled = false
        }
    }

    private fun getCurrentCheckedInLocation(): Location? {
        // Replace this with actual logic to retrieve the current checked-in location
        val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val locationName = sharedPreferences.getString("checked_in_location", null)
        return if (locationName != null) {
            Location(name = locationName, address = "", email = "", active = true)
        } else {
            null
        }
    }

    private fun checkOutFromLocation(location: Location) {
        // Replace this with actual logic to check out from the location
        val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().remove("checked_in_location").apply()
        Toast.makeText(this, "Checked out from ${location.name}", Toast.LENGTH_SHORT).show()
        finish()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, CheckOutActivity::class.java)
            context.startActivity(intent)
        }
    }
}
