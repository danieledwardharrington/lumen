package com.deh.lumen.core_data.entity

import androidx.room.Entity
import androidx.room.Index
import com.deh.lumen.core_data.CoreDataConstants

@Entity(
    tableName = CoreDataConstants.CHECK_IN_TABLE_NAME,
    indices = [
        Index(value = ["date"], unique = true)  // enforces one entry per day at the database level
    ]
)
data class CheckInEntity()
