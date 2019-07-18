package com.example.grocer21.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.grocer21.database.daos.*
import com.example.grocer21.database.entities.*

/**
 * class which represents the database
 *
 * [Room] implementation
 */
@Database(entities = [
    Allergies::class,
    DietFoods::class,
    Diets::class,
    FoodAllergens::class,
    Foods::class,
    Profile::class,
    ShoppingList::class,
    UserAllergies::class,
    UserDiets::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {
    /**
     * Constructor definition method for the [allergiesDao] interface
     */
    abstract fun allergiesDao(): AllergiesDao

    /**
     * Constructor definition method for the [dietFoodsDao] interface
     */
    abstract fun dietFoodsDao(): DietFoodsDao

    /**
     * Constructor definition method for the [dietsDao] interface
     */
    abstract fun dietsDao(): DietsDao

    /**
     * Constructor definition method for the [foodAllergensDao] interface
     */
    abstract fun foodAllergensDao(): FoodAllergensDao

    /**
     * Constructor definition method for the [foodsDao] interface
     */
    abstract fun foodsDao(): FoodsDao

    /**
     * Constructor definition method for the [profileDao] interface
     */
    abstract fun profileDao(): ProfileDao

    /**
     * Constructor definition method for the [shoppingListDao] interface
     */
    abstract fun shoppingListDao(): ShoppingListDao

    /**
     * Constructor definition method for the [userAllergiesDao] interface
     */
    abstract fun userAllergiesDao(): UserAllergiesDao

    /**
     * Constructor definition method for the [userDietsDao] interface
     */
    abstract fun userDietsDao(): UserDietsDao

    companion object {
        @Volatile
        internal var instance: AppDatabase? = null

        /**
         * function to fetch the [AppDatabase]'s current iteration
         */
        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val mInstance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "App_database"
                ).build()
                instance = mInstance
                return mInstance
            }
        }
    }
}
