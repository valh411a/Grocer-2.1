package com.example.grocer21.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Class representation of the "Profile table
 */
@Entity(tableName = "profile")
data class Profile(
        /**
         * value representing the "userID" column
         */
        @PrimaryKey(autoGenerate = true) val userID: Int,
        /**
         * value representing the "user_name" column
         */
        @ColumnInfo(name = "user_name") val userName: String?
)