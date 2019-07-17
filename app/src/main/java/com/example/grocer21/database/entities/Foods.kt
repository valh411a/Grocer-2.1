package com.example.grocer21.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Foods")
data class Foods(
        @PrimaryKey val upc: Long,
        @ColumnInfo(name = "food_type") val foodType: String?
) {
    fun getName(): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}