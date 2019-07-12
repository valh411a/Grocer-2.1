package com.example.grocer21.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "Foods")
data class Foods(
        @PrimaryKey val upc: Int,
        @ColumnInfo(name = "food_type") val foodType: String?
)