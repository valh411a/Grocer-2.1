package com.example.grocer21.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "Allergies")
data class Allergies(
        @PrimaryKey val allergyID: Int,
        @ColumnInfo(name = "allergy_type") val allergyType: String?
) {
    fun getName(): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}