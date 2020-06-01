package com.tomjerry.appscovid19.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tomjerry.appscovid19.model.*

@Database(entities = [Indonesia::class , Makassar::class , Kasus::class , Sembuh::class , Meninggal::class , Golongan::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun covidSetDao(): CovidSetDao

    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            instance?.let { return it }
            instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "covid"
            ).build()
            return instance!!
        }
    }
}