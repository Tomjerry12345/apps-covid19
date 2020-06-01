package com.tomjerry.appscovid19.repository

import android.util.Log
import com.tomjerry.appscovid19.data.datastore.CovidDataStore
import com.tomjerry.appscovid19.model.*

class CovidRepository private constructor() : BaseRepository<CovidDataStore>() {

    suspend fun getIndonesia(): List<Indonesia>? {
        val cache = localDataStore?.getIndonesia()
        Log.println(Log.ASSERT , "cache" , "$cache")
        if (cache != null) return cache
        val response = remoteDataStore?.getIndonesia()
        localDataStore?.addIndonesia(response)
        return response
    }

    suspend fun getResponse() {
        val responseIndonesia = remoteDataStore?.getIndonesia()
        val responseMakassar = remoteDataStore?.getMakassar()
        val responseKasus = remoteDataStore?.getKasus()
        val responseMeninggal = remoteDataStore?.getMeninggal()
        val responseSembuh = remoteDataStore?.getSembuh()
        localDataStore?.updateIndonesia(responseIndonesia)
        localDataStore?.updateMakassar(responseMakassar)
        localDataStore?.updateKasus(responseKasus)
        localDataStore?.updateMeninggal(responseMeninggal)
        localDataStore?.updateSembuh(responseSembuh)
    }

    suspend fun getMakassar(): List<Makassar>? {
        val cache = localDataStore?.getMakassar()
        if (cache != null) return cache
        val response = remoteDataStore?.getMakassar()
        localDataStore?.addMakassar(response)
        return response
    }

    suspend fun getKasus(): List<Kasus>? {
        val cache = localDataStore?.getKasus()
        if (cache != null) return cache
        val response = remoteDataStore?.getKasus()
        localDataStore?.addKasus(response)
        return response
    }

    suspend fun getSembuh(): List<Sembuh>? {
        val cache = localDataStore?.getSembuh()
        if (cache != null) return cache
        val response = remoteDataStore?.getSembuh()
        localDataStore?.addSembuh(response)
        return response
    }

    suspend fun getMeninggal(): List<Meninggal>? {
        val cache = localDataStore?.getMeninggal()
        if (cache != null) return cache
        val response = remoteDataStore?.getMeninggal()
        localDataStore?.addMeninggal(response)
        return response
    }

    suspend fun getGolongan(): List<Golongan>? {
        return localDataStore?.getGolongan()
    }

    suspend fun addGolongan(list: List<Golongan> , list1: List<Golongan>?) {
        localDataStore?.addGolongan(list , list1)
    }

    companion object {
        val instance by lazy { CovidRepository() }
    }
}