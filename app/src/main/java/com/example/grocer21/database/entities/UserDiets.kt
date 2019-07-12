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
            entity = Diets::class,
            parentColumns = arrayOf("dietID"),
            childColumns = arrayOf("dietID")
    )
])
data class UserDiets (
        @PrimaryKey val userID: Int,
        @PrimaryKey val dietID: Int
)