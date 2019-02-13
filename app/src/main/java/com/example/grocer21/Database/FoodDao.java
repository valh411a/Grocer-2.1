package com.example.grocer21.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FoodDao {

    @Insert
    void insert(Food food);

    @Query("DELETE FROM food_table")
    void deleteAll();

    @Query("SELECT * from food_table ORDER BY upc DESC")
    LiveData<List<Food>> getAllFoods();

    @Delete
    void delete(Food food);
}
