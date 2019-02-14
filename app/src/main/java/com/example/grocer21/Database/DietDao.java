package com.example.grocer21.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DietDao {

    @Insert
    void insert(Diet diet);

    @Query("SELECT * FROM diet_table ORDER BY name")
    LiveData<List<Diet>> getAllDiets();

    @Delete
    void delete(Diet diet);

    @Query("DELETE FROM diet_table")
    void deleteAll();
}
