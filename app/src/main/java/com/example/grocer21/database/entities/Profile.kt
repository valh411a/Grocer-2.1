package com.example.grocer21.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Profile")
data class Profile(
        @PrimaryKey val userID: Int,
        @ColumnInfo(name = "user_name") val userName: String?
)