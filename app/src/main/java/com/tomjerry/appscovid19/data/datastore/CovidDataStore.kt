package com.tomjerry.appscovid19.data.datastore

import com.tomjerry.appscovid19.model.*

interface CovidDataStore {
    suspend fun getIndonesia(): List<Indonesia>?
    suspend fun getMakassar(): List<Makassar>?
    suspend fun getKasus(): List<Kasus>?
    suspend fun getSembuh(): List<Sembuh>?
    suspend fun getMeninggal(): List<Meninggal>?
    suspend fun getGolongan(): List<Golongan>?
    suspend fun addIndonesia(indonesia: List<Indonesia>?)
    suspend fun updateIndonesia(indonesia: List<Indonesia>?)
    suspend fun addMakassar(makassar: List<Makassar>?)
    suspend fun updateMakassar(makassar: List<Makassar>?)
    suspend fun addKasus(kasus: List<Kasus>?)
    suspend fun updateKasus(kasus: List<Kasus>?)
    suspend fun addSembuh(sembuh: List<Sembuh>?)
    suspend fun updateSembuh(sembuh: List<Sembuh>?)
    suspend fun addMeninggal(meninggal: List<Meninggal>?)
    suspend fun updateMeninggal(meninggal: List<Meninggal>?)
    suspend fun addGolongan(golongan: List<Golongan>? , golongan1: List<Golongan>?)
}