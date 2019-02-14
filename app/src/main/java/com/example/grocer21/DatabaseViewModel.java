package com.example.grocer21;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.grocer21.Database.Allergy;
import com.example.grocer21.Database.AppRepository;
import com.example.grocer21.Database.Food;

import java.util.List;

public class DatabaseViewModel extends AndroidViewModel {

    private AppRepository appRepository;
    public final LiveData<List<Food>> allFoods;
    public final LiveData<List<Allergy>> allAllergies;

    public DatabaseViewModel(@NonNull Application application) {
        super(application);
        appRepository = new AppRepository(application);
        allFoods = appRepository.getAllFoods();
        allAllergies = appRepository.getAllAllergies();
    }

    LiveData<List<Food>> getAllFoods() {
        return allFoods;
    }

    public void insert(Food food) {
        appRepository.insert(food);
    }

    public LiveData<List<Allergy>> getAllAllergies() {
        return allAllergies;
    }
}
