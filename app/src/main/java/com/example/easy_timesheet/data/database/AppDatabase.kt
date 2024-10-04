package com.example.easy_timesheet.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.easy_timesheet.data.entities.Location
import com.yourpackage.data.dao.LocationDao


@Database(entities = [Location::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao
}
