// Location.kt
    package com.example.easytimesheet.models

    import androidx.room.Entity
    import androidx.room.PrimaryKey

    @Entity(tableName = "locations")
    data class Location(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        val name: String,
        val address: String,
        val email: String
    )


