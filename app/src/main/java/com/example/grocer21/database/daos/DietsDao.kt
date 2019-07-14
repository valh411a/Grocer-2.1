package com.example.grocer21.database.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.grocer21.database.entities.Diets

@Dao
interface DietsDao {
    @Query("SELECT * FROM Diets")
    fun loadAllDiets(): LiveData<List<Diets>>
}