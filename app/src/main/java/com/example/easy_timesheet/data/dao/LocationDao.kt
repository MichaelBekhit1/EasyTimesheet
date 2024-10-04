package com.yourpackage.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.easy_timesheet.data.entities.Location


@Dao
interface LocationDao {
    @Insert
    suspend fun insert(location: Location)

    @Query("SELECT * FROM locations")
    suspend fun getAllLocations(): List<Location>
}
