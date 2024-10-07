package com.yourpackage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easy_timesheet.activities.AddLocationActivity
import com.example.easy_timesheet.data.entities.Location
import com.example.easytimesheet.R

class ActiveLocationsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addLocationButton: Button
    private lateinit var checkOutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_active_locations)

        recyclerView = findViewById(R.id.recyclerView)
        addLocationButton = findViewById(R.id.addLocationButton)
        checkOutButton = findViewById(R.id.checkOutButton) // Define the checkOutButton

        addLocationButton.setOnClickListener {
            val intent = Intent(this, AddLocationActivity::class.java)
            startActivity(intent)
        }

        val activeLocations = getActiveLocations()
        val adapter = LocationAdapter(activeLocations) { location ->
            checkInAtLocation(location)
        }
        checkOutButton.setOnClickListener {
            CheckOutActivity.start(this)
        }



        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun getActiveLocations(): List<Location> {
        // Replace this with actual data retrieval logic
        return listOf(
            Location(name = "Central Park", address = "New York, NY", email = "info@centralpark.com", active = true),
            Location(name = "Golden Gate Park", address = "San Francisco, CA", email = "info@goldengatepark.com", active = true)
        ).filter { it.active }
    }

    private fun checkInAtLocation(location: Location) {
        // Implement check-in logic here
        val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("checked_in_location", location.name).apply()
        Toast.makeText(this, "Checked in at ${location.name}", Toast.LENGTH_SHORT).show()
    }
}
