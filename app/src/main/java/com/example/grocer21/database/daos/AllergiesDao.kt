package com.example.grocer21.database.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.grocer21.database.entities.Allergies

/**
 * Interface for the [Allergies] entity
 */
@Dao
interface AllergiesDao {

    /**
     * query function to fetch a list of all entries in the "allergies" table
     */
    @Query("SELECT * FROM Allergies")
    fun loadAllAllergies(): LiveData<List<Allergies>>
}