package com.example.grocer21

import androidx.lifecycle.LiveData
import androidx.annotation.WorkerThread
import com.example.grocer21.database.daos.*
import com.example.grocer21.database.entities.Allergies
import com.example.grocer21.database.entities.Diets
import com.example.grocer21.database.entities.Foods

class AppRepository(
        allergiesDao: AllergiesDao,
        dietsDao: DietsDao,
        private val foodsDao: FoodsDao) {

    val allFoods: LiveData<List<Foods>> = foodsDao.loadAllFoods()
    val allAllergies: LiveData<List<Allergies>> = allergiesDao.loadAllAllergies()
    val allDiets: LiveData<List<Diets>> = dietsDao.loadAllDiets()

    @WorkerThread
    fun insert(food: Foods) {
        foodsDao.insert(food)
    }
}