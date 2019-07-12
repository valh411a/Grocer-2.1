package com.example.grocer21.database.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [
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
        @PrimaryKey val foodID: Int,
        @PrimaryKey val allergyID: Int
)