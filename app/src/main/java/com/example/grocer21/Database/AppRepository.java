package com.example.grocer21.Database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AppRepository {

    private FoodDao foodDao;
    private LiveData<List<Food>> allFoods;

    public AppRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        foodDao = db.foodDao();
        allFoods = foodDao.getAllFoods();
    }

    public LiveData<List<Food>> getAllFoods() {
        return allFoods;
    }

    public void insert (Food food) {
        new insertAsyncTask(foodDao).execute(food);
    }

    public void delete(Food food) {
        new deleteAsyncTask(foodDao).execute(food);
    }

    private static class insertAsyncTask extends AsyncTask<Food, Void, Void> {

        private FoodDao aSyncTaskDao;

        insertAsyncTask(FoodDao foodDao) {
            aSyncTaskDao = foodDao;
        }

        @Override
        protected Void doInBackground(final Food... foods) {
            aSyncTaskDao.insert(foods[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Food, Void, Void> {

        private FoodDao aSyncTaskDao;

        deleteAsyncTask(FoodDao foodDao) {
            aSyncTaskDao = foodDao;
        }

        @Override
        protected Void doInBackground(final Food... foods) {
            aSyncTaskDao.delete(foods[0]);
            return null;
        }
    }
}
