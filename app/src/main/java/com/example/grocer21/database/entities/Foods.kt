package com.example.grocer21.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "Foods")
data class Foods(
        @PrimaryKey val upc: Long,
        @ColumnInfo(name = "food_type") val foodType: String?
) {
    fun getName(): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}