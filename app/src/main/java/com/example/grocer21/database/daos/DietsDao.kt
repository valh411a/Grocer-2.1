package com.example.grocer21.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
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