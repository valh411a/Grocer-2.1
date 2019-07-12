package com.example.grocer21.database.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [
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
        @PrimaryKey val userID: Int,
        @PrimaryKey val allergyID: Int
)