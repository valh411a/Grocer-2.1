package com.example.grocer21.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(primaryKeys = ["userID", "upc"],
        foreignKeys = [
            ForeignKey(
                    entity = Profile::class,
                    parentColumns = arrayOf("userID"),
                    childColumns = arrayOf("userID")),
            ForeignKey(
                    entity = Foods::class,
                    parentColumns = arrayOf("upc"),
                    childColumns = arrayOf("upc")
            )
        ])
data class ShoppingList(
        val userID: Int,
        val upc: Long
)