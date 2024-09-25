// CheckIn.kt
package com.example.easytimesheet.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "check_ins")
data class CheckIn(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val locationId: Int,
    val checkInTime: Long,
    val checkOutTime: Long? = null
)