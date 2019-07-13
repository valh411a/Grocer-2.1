package com.example.grocer21.database.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.grocer21.database.entities.Foods

@Dao
interface FoodsDao {
    @Query("SELECT * FROM Foods")
    fun loadAllFoods(): LiveData<List<Foods>>
}