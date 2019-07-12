package com.example.grocer21

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

import com.example.grocer21.database.entities.Allergies
import com.example.grocer21.database.AppRepository
import com.example.grocer21.database.Diet
import com.example.grocer21.database.Food

internal class DatabaseViewModel(application: Application) : AndroidViewModel(application) {

    private val appRepository: AppRepository
    val allFoods: LiveData<List<Food>>
    val allAllergies: LiveData<List<Allergies>>
    val allDiets: LiveData<List<Diet>>

    init {
        appRepository = AppRepository(application)

        allFoods = appRepository.getAllFoods()
        allAllergies = appRepository.getAllAllergies()
        allDiets = appRepository.getAllDiets()
    }

    fun insert(food: Food) {
        appRepository.insert(food)
    }

    fun insert(allergy: Allergy) {
        appRepository.insert(allergy)
    }

    fun insert(diet: Diet) {
        appRepository.insert(diet)
    }
}
