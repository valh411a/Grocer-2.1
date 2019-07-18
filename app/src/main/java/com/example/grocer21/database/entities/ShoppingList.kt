package com.example.grocer21.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

/**
 * Class representation of the "shoppinglist" joint table,
 * joins [userID] and [Foods]
 */
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
        /**
         * value for the foreign key from the [Profile] table
         */
        val userID: Int,
        /**
         * value for the foreign key from the [Foods] table
         */
        val upc: Long
)