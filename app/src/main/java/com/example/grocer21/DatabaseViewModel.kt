package com.example.grocer21

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocer21.database.AppDatabase
import com.example.grocer21.database.entities.Allergies
import com.example.grocer21.database.entities.Diets
import com.example.grocer21.database.entities.Foods
import kotlinx.coroutines.launch

internal class DatabaseViewModel(application: Application) : ViewModel() {
    private val repository: AppRepository
    val allFoods: LiveData<List<Foods>>
    val allAllergies: LiveData<List<Allergies>>
    val allDiets: LiveData<List<Diets>>

    init {
    }

    init {
        val foodsDao = AppDatabase.getDatabase(application).foodsDao()
        val allergiesDao = AppDatabase.getDatabase(application).allergiesDao()
        val dietFoodsDao = AppDatabase.getDatabase(application).dietFoodsDao()
        val dietsDao = AppDatabase.getDatabase(application).dietsDao()
        val foodAllergensDao = AppDatabase.getDatabase(application).foodAllergensDao()
        val profileDao = AppDatabase.getDatabase(application).profileDao()
        val shoppingListDao = AppDatabase.getDatabase(application).shoppingListDao()
        val userAllergiesDao = AppDatabase.getDatabase(application).userAllergiesDao()
        val userDietsDao = AppDatabase.getDatabase(application).userDietsDao()
        repository = AppRepository(
                allergiesDao,
                dietsDao,
                foodsDao)

        allFoods = repository.allFoods
        allAllergies = repository.allAllergies
        allDiets = repository.allDiets

    }

    fun insertWrapper(food: Foods) {
        viewModelScope.launch {
            insert(food)
        }
    }

    private fun insert(food: Foods) {
        repository.insert(food)
    }

}
