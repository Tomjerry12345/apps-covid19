package com.tomjerry.appscovid19.data.datastore

import com.tomjerry.appscovid19.model.*

interface CovidDataStore {
    suspend fun getIndonesia(): List<Indonesia>?
    suspend fun getMakassar(): List<Makassar>?
    suspend fun getKasus(): List<Kasus>?
    suspend fun getSembuh(): List<Sembuh>?
    suspend fun getMeninggal(): List<Meninggal>?
    suspend fun addIndonesia(indonesia: List<Indonesia>?)
    suspend fun addMakassar(makassar: List<Makassar>?)
    suspend fun addKasus(kasus: List<Kasus>?)
    suspend fun addSembuh(sembuh: List<Sembuh>?)
    suspend fun addMeninggal(meninggal: List<Meninggal>?)
}