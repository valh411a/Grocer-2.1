package com.example.grocer21.database.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

/**
 * Entity representation of the "DietFoods" table in the database
 */
@Entity(primaryKeys = ["dietID", "upc"],
        foreignKeys = [
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
data class DietFoods(

        /**
         * foreign key representing the [Diets] table
         */
        val dietID: Int,

        /**
         * foreign key representing the [Foods] table
         */
        val upc: Long
)