package com.example.grocer21.database.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.grocer21.database.entities.Diets

/**
 * Interface for the [Diets] entity
 */
@Dao
interface DietsDao {
    /**
     * query function to fetch a list of all entries in the "diets" table
     */
    @Query("SELECT * FROM Diets")
    fun loadAllDiets(): LiveData<List<Diets>>
}