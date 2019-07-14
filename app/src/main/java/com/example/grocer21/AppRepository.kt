package com.example.grocer21

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import com.example.grocer21.database.daos.*
import com.example.grocer21.database.entities.Allergies
import com.example.grocer21.database.entities.Diets
import com.example.grocer21.database.entities.Foods

class AppRepository(
        private val allergiesDao: AllergiesDao,
    private val dietFoodsDao: DietFoodsDao,
        private val dietsDao: DietsDao,
        private val foodAllergensDao: FoodAllergensDao,
        private val foodsDao: FoodsDao,
        private val profileDao: ProfileDao,
        private val shoppingListDao: ShoppingListDao,
        private val userAllergiesDao: UserAllergiesDao,
        private val userDietsDao: UserDietsDao) {

    val allFoods: LiveData<List<Foods>> = foodsDao.loadAllFoods()
    val allAllergies: LiveData<List<Allergies>> = allergiesDao.loadAllAllergies()
    val allDiets: LiveData<List<Diets>> = dietsDao.loadAllDiets()

    @WorkerThread
    fun insert(food: Foods) {
        foodsDao.insert(food)
    }
}