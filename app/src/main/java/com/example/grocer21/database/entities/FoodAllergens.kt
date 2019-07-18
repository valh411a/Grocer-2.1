package com.example.grocer21.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

/**
 * Class representation of the "FoodAllergens" joint table that separates the
 * [Foods] and [Allergies] tables
 */
@Entity(primaryKeys = ["upc", "allergyID"],
        foreignKeys = [
            ForeignKey(
                    entity = Foods::class,
                    parentColumns = arrayOf("upc"),
                    childColumns = arrayOf("upc")),
            ForeignKey(
                    entity = Allergies::class,
                    parentColumns = arrayOf("allergyID"),
                    childColumns = arrayOf("allergyID")
            )
        ])
data class FoodAllergens(
        /**
         * value representing the "upc" composite key column
         */
        val upc: Long,
        /**
         * value representing the "allergyID" composite key column
         */
        val allergyID: Int
)