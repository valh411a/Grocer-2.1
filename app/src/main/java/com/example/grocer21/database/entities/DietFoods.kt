package com.example.grocer21.database.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(
        entity = Diets::class,
        parentColumns = arrayOf("dietID"),
        childColumns = arrayOf("dietID")),
    ForeignKey(
        entity = Foods::class,
        parentColumns = arrayOf("upc"),
        childColumns = arrayOf("upc")
    )
])
data class DietFoods (
        @PrimaryKey val dietID: Int,
        @PrimaryKey val foodID: Int
)