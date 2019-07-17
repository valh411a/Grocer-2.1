package com.example.grocer21.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Allergies")
data class Allergies(
        @PrimaryKey val allergyID: Int,
        @ColumnInfo(name = "allergy_type") val allergyType: String?
) {
    fun getName(): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}