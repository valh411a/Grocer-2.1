package com.example.grocer21.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.grocer21.database.entities.Foods


/**
 * Interface for the [Foods] entity
 */
@Dao
interface FoodsDao {
    /**
     * query function to fetch a list of all entries in the "foods" table
     */
    @Query("SELECT * FROM Foods")
    fun loadAllFoods(): LiveData<List<Foods>>

    /**
     * $$BROKEN$$ function to insert a new food into the "foods" table
     */
    @Insert
    fun insert(food: Foods)
}