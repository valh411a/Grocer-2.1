package com.example.grocer21.database

import android.app.Application
import android.arch.lifecycle.LiveData
import com.example.grocer21.database.daos.FoodsDao
import com.example.grocer21.database.entities.Allergies
import com.example.grocer21.database.entities.Diets
import com.example.grocer21.database.entities.Foods

class AppRepository (application: Application){
    var database: AppDatabase = AppDatabase.getDatabase(application)
    fun getAllFoods(): LiveData<List<Foods>> {

    }
    fun getAllAllergies(): LiveData<List<Allergies>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getAllDiets(): LiveData<List<Diets>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
