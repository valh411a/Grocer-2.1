package com.example.grocer21.database.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

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
data class UserAllergies (
        val userID: Int,
        val allergyID: Int
)