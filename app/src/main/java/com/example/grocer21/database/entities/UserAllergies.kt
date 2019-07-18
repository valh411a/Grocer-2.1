package com.example.grocer21.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

/**
 * Class representation of the "userallergies" table,
 * joins [Profile] table and [Allergies] table
 */
@Entity(primaryKeys = ["userID", "allergyID"],
        foreignKeys = [
            ForeignKey(
                    entity = Profile::class,
                    parentColumns = arrayOf("userID"),
                    childColumns = arrayOf("userID")),
            ForeignKey(
                    entity = Allergies::class,
                    parentColumns = arrayOf("allergyID"),
                    childColumns = arrayOf("allergyID")
            )
        ])
data class UserAllergies(
        /**
         * value for the foreign key from the [Profile] table
         */
        val userID: Int,
        /**
         * value for the foreign key from the [Allergies] table
         */
        val allergyID: Int
)