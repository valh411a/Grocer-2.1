package com.example.grocer21

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.grocer21.database.daos.AllergiesDao
import com.example.grocer21.database.daos.DietsDao
import com.example.grocer21.database.daos.FoodsDao
import com.example.grocer21.database.entities.Allergies
import com.example.grocer21.database.entities.Diets
import com.example.grocer21.database.entities.Foods

/**
 * Repository to handle interactions with the database's DAO's]
 */
class AppRepository(
        allergiesDao: AllergiesDao,
        dietsDao: DietsDao,
        private val foodsDao: FoodsDao) {

    /**
     * value representing the database's current list of all [Foods]
     */
    val allFoods: LiveData<List<Foods>> = foodsDao.loadAllFoods()
    /**
     * value representing the database's current list of all [Allergies]
     */
    val allAllergies: LiveData<List<Allergies>> = allergiesDao.loadAllAllergies()
    /**
     * value representing the database's current list of all [Diets]
     */
    val allDiets: LiveData<List<Diets>> = dietsDao.loadAllDiets()

    /**
     * Co-routine that handles the insertion of foods into the database using the [FoodsDao]
     */
    @WorkerThread
    fun insert(food: Foods) {
        foodsDao.insert(food)
    }
}