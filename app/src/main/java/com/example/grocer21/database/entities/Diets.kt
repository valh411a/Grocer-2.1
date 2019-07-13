package com.example.grocer21.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "Diets")
data class Diets(
        @PrimaryKey val dietID: Int,
        @ColumnInfo(name = "diet_type") val dietType: String?
) {
    fun getName(): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}