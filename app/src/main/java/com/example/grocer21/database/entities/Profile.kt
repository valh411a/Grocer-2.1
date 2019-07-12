package com.example.grocer21.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "Profile")
data class Profile(
        @PrimaryKey val userID: Int,
        @ColumnInfo(name = "user_name") val userName: String?
)