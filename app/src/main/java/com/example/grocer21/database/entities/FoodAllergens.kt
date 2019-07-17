package com.example.grocer21.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

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
data class FoodAllergens (
        val upc: Long,
        val allergyID: Int
)