package com.example.grocer21.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Food.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FoodDao foodDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "word_database").addCallback(appDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback appDatabaseCallback = new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final FoodDao fDao;

        PopulateDbAsync(AppDatabase db) {
            fDao = db.foodDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            fDao.deleteAll();
            Food food = new Food("Chicken", 1111111111);
            fDao.insert(food);
            food = new Food("Pork", 1111111112);
            fDao.insert(food);
            return null;
        }
    }
}
