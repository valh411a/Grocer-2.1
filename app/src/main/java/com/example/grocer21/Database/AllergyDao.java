package com.example.grocer21.Database;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AllergyDao {

    @Insert
    void insert(Allergy allergy);

    @Query("SELECT * from allergy_table ORDER BY name")
    LiveData<List<Allergy>> getAllAllergies();

    @Delete
    void delete(Allergy allergy);

    @Query("DELETE FROM allergy_table")
    void deleteAll();
}