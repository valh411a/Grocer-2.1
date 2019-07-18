package com.example.grocer21.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Class representation of the "Foods" table
 */
@Entity(tableName = "Foods")
data class Foods(
        /**
         * value for the "upc" column
         */
        @PrimaryKey val upc: Long,
        /**
         * value of the "food_type" column
         */
        @ColumnInfo(name = "food_type") val foodType: String?
) {
    /**
     * getter method for the food name
     */
    fun getName(): String? {
        TODO("not implemented")
    }
}