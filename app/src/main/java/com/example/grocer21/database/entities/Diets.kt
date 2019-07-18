package com.example.grocer21.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Class representation of the "Diets" table
 */
@Entity(tableName = "Diets")
data class Diets(
        /**
         * value representing the "dietID" column
         */
        @PrimaryKey val dietID: Int,
        /**
         * value representing the "diet_type" column
         */
        @ColumnInfo(name = "diet_type") val dietType: String?
) {
    /**
     * function for getting the name of a diet
     */
    fun getName(): String? {
        return dietType
    }
}