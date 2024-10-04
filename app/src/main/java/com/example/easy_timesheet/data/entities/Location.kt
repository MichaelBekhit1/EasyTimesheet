// Location.kt
    package com.example.easy_timesheet.data.entities

    import androidx.room.Entity
    import androidx.room.PrimaryKey

    @Entity(tableName = "locations")
    data class Location(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        val name: String,
        val address: String,
        val email: String,
        val active: Boolean
    )


