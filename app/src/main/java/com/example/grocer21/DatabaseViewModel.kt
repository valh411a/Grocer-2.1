package com.example.grocer21

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

import com.example.grocer21.database.entities.Allergies
import com.example.grocer21.database.AppRepository
import com.example.grocer21.database.entities.Diets
import com.example.grocer21.database.entities.Foods

internal class DatabaseViewModel(application: Application) : AndroidViewModel(application) {

    val allFoods: LiveData<List<Foods>>
    val allAllergies: LiveData<List<Allergies>>
    val allDiets: LiveData<List<Diets>>
    private val appRepository: AppRepository = AppRepository()

    init {

        allFoods = appRepository.getAllFoods()
        allAllergies = appRepository.getAllAllergies()
        allDiets = appRepository.getAllDiets()
    }

}
