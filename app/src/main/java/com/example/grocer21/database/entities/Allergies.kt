package com.example.grocer21.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Entity class representing the "Allergies" table
 */
@Entity(tableName = "Allergies")
data class Allergies(
        /**
         * property representing the "allergyID" column
         */
        @PrimaryKey val allergyID: Int,
        /**
         * property representing the "allergy_type" column
         */
        @ColumnInfo(name = "allergy_type") val allergyType: String?
) {
    /**
     * Function to return the "AllergyID" of a given allergy
     */
    fun getName(): String? {
        TODO("not implemented")
    }
}