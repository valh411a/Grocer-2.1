package com.example.grocer21.database.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.grocer21.database.entities.Allergies

@Dao
interface AllergiesDao {

    @Query("SELECT * FROM Allergies")
    fun loadAllAllergies(): LiveData<List<Allergies>>
}