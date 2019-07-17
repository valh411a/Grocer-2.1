package com.example.grocer21.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Diets")
data class Diets(
        @PrimaryKey val dietID: Int,
        @ColumnInfo(name = "diet_type") val dietType: String?
) {
    fun getName(): String? {
        return dietType
    }
}