package com.example.grocer21.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

/**
 * Class representation of the "userdiets" table,
 * join [Profile] table and [Diets] table
 */
@Entity(primaryKeys = ["userID", "dietID"],
        foreignKeys = [
            ForeignKey(
                    entity = Profile::class,
                    parentColumns = arrayOf("userID"),
                    childColumns = arrayOf("userID")),
            ForeignKey(
                    entity = Diets::class,
                    parentColumns = arrayOf("dietID"),
                    childColumns = arrayOf("dietID")
            )
        ])
data class UserDiets(
        /**
         * value for the foreign key from the [Profile] table
         */
        val userID: Int,
        /**
         * value for the foreign key from the [Diets] table
         */
        val dietID: Int
)