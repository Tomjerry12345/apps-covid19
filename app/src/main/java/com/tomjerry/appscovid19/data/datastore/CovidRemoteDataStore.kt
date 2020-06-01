package com.tomjerry.appscovid19.data.datastore

import com.tomjerry.appscovid19.data.webservices.CovidService
import com.tomjerry.appscovid19.model.*

class CovidRemoteDataStore(private val covidService: CovidService) : CovidDataStore {

    override suspend fun getIndonesia(): List<Indonesia>? {
        val response = covidService.getIndonesia()
        if (response.isSuccessful) return response.body()

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun getMakassar(): List<Makassar>? {
        val response = covidService.getMakassar()
        if (response.isSuccessful) return response.body()

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun getKasus(): List<Kasus>? {
        val response = covidService.getKasus()
        if (response.isSuccessful) return response.body()

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun getSembuh(): List<Sembuh>? {
        val response = covidService.getSembuh()
        if (response.isSuccessful) return response.body()

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun getMeninggal(): List<Meninggal>? {
        val response = covidService.getMeninggal()
        if (response.isSuccessful) return response.body()

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun getGolongan(): List<Golongan>? {
        TODO()
    }

    override suspend fun addIndonesia(indonesia: List<Indonesia>?) {}

    override suspend fun updateIndonesia(indonesia: List<Indonesia>?) {}

    override suspend fun addMakassar(makassar: List<Makassar>?) {}

    override suspend fun updateMakassar(makassar: List<Makassar>?) {}

    override suspend fun addKasus(kasus: List<Kasus>?) {}

    override suspend fun updateKasus(kasus: List<Kasus>?) {}

    override suspend fun addSembuh(sembuh: List<Sembuh>?) {}

    override suspend fun updateSembuh(sembuh: List<Sembuh>?) {}

    override suspend fun addMeninggal(meninggal: List<Meninggal>?) {}

    override suspend fun updateMeninggal(meninggal: List<Meninggal>?) {}

    override suspend fun addGolongan(golongan: List<Golongan>? , golongan1: List<Golongan>?) {}
}