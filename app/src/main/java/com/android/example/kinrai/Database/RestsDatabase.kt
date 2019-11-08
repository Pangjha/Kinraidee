package com.android.example.kinrai.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.example.kinrai.Resterant


@Database(entities = [Resterant::class], version = 3, exportSchema = false)
abstract class RestsDatabase : RoomDatabase() {

    abstract val restsDatabaseDao: RestsDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: RestsDatabase? = null

        fun getInstance(context: Context): RestsDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RestsDatabase::class.java,
                        "rests_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}