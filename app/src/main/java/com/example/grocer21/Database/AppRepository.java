package com.example.grocer21.Database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Entity;
import android.os.AsyncTask;

import java.util.List;

public class AppRepository {

    private FoodDao foodDao;
    private AllergyDao allergyDao;
    private DietDao dietDao;

    private LiveData<List<Food>> allFoods;
    private LiveData<List<Allergy>> allAllergies;
    private LiveData<List<Diet>> allDiets;

    public AppRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);

        foodDao = db.foodDao();
        allergyDao = db.allergyDao();
        dietDao = db.dietDao();

        allFoods = foodDao.getAllFoods();
        allAllergies = allergyDao.getAllAllergies();
        allDiets = dietDao.getAllDiets();
    }

    public LiveData<List<Food>> getAllFoods() {
        return allFoods;
    }
    public LiveData<List<Allergy>> getAllAllergies() {
        return allAllergies;
    }
    public LiveData<List<Diet>> getAllDiets() {
        return allDiets;
    }


    public void insert (Food food) {
        new insertAsyncTask(foodDao).execute();
    }
    public void insert (Allergy allergy) {
        new insertAsyncTask(allergyDao).execute();
    }
    public void insert (Diet diet) { new insertAsyncTask(dietDao).execute(); }

    public void delete(Food food) {
        new deleteAsyncTask(foodDao).execute();
    }
    public void delete(Allergy allergy) {
        new deleteAsyncTask(allergyDao).execute();
    }
    public void delete(Diet diet) {
        new deleteAsyncTask(dietDao).execute();
    }

    private static class insertAsyncTask extends AsyncTask<Entity, Void, Void> {

        private FoodDao aSyncTaskFoodDao;
        private AllergyDao aSyncTaskAllergyDao;
        private DietDao aSyncTaskDietDao;

        insertAsyncTask(FoodDao foodDao) {
            aSyncTaskFoodDao = foodDao;
        }
        insertAsyncTask(AllergyDao allergyDao) {
            aSyncTaskAllergyDao = allergyDao;
        }
        insertAsyncTask(DietDao dietDao) {
            aSyncTaskDietDao = dietDao;
        }

        @Override
        protected Void doInBackground(Entity... entities) {
            aSyncTaskFoodDao.insert((Food)entities[0]);
            aSyncTaskAllergyDao.insert((Allergy)entities[0]);
            aSyncTaskDietDao.insert((Diet)entities[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Entity, Void, Void> {

        private FoodDao daSyncTaskDao;
        private AllergyDao daSyncTaskAllergyDao;
        private DietDao daSyncTaskDietDao;

        deleteAsyncTask(FoodDao foodDao) {
            daSyncTaskDao = foodDao;
        }
        deleteAsyncTask(AllergyDao allergyDao) {
            daSyncTaskAllergyDao = allergyDao;
        }
        deleteAsyncTask(DietDao dietDao) {
            daSyncTaskDietDao = dietDao;
        }

        @Override
        protected Void doInBackground(Entity... entities) {
            daSyncTaskDao.delete((Food)entities[0]);
            daSyncTaskAllergyDao.delete((Allergy)entities[0]);
            daSyncTaskDietDao.delete((Diet)entities[0]);
            return null;
        }
    }
}
