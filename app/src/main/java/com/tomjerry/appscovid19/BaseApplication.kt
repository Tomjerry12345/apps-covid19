package com.tomjerry.appscovid19

import android.app.Application
import com.tomjerry.appscovid19.data.database.AppDatabase
import com.tomjerry.appscovid19.data.datastore.CovidRemoteDataStore
import com.tomjerry.appscovid19.data.datastore.CovidRoomDataStore
import com.tomjerry.appscovid19.repository.CovidRepository
import com.tomjerry.appscovid19.data.webservices.RetrofitApp

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val covidService = RetrofitApp.COVID_SERVICE
        val appDatabase = AppDatabase.getInstance(this)
        CovidRepository.instance.apply {
            init(
                CovidRoomDataStore(appDatabase.covidSetDao()),
                CovidRemoteDataStore(covidService)
            )
        }
    }
}