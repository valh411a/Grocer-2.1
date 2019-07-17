package com.example.grocer21.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

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
        val userID: Int,
        val dietID: Int
)