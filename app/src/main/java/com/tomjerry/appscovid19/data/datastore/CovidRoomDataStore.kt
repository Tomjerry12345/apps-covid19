package com.tomjerry.appscovid19.data.datastore

import com.tomjerry.appscovid19.data.database.CovidSetDao
import com.tomjerry.appscovid19.model.*

class CovidRoomDataStore(private val covidSetDao: CovidSetDao) : CovidDataStore {

    override suspend fun getIndonesia(): List<Indonesia>? {
        val response = covidSetDao.getIndonesia()
        return if (response.isEmpty()) null else response
    }

    override suspend fun getMakassar(): List<Makassar>? {
        val response = covidSetDao.getMakassar()
        return if (response.isEmpty()) null else response
    }

    override suspend fun getKasus(): List<Kasus>? {
        val response = covidSetDao.getKasus()
        return if (response.isEmpty()) null else response
    }

    override suspend fun getSembuh(): List<Sembuh>? {
        val response = covidSetDao.getSembuh()
        return if (response.isEmpty()) null else response
    }

    override suspend fun getMeninggal(): List<Meninggal>? {
        val response = covidSetDao.getMeninggal()
        return if (response.isEmpty()) null else response
    }

    override suspend fun addIndonesia(indonesia: List<Indonesia>?) {
        indonesia?.let { covidSetDao.insertIndonesia() }
    }

    override suspend fun addMakassar(makassar: List<Makassar>?) {
        makassar?.let { covidSetDao.inserMakassar() }
    }

    override suspend fun addKasus(kasus: List<Kasus>?) {
        kasus?.let { covidSetDao.insertKasus() }
    }

    override suspend fun addSembuh(sembuh: List<Sembuh>?) {
        sembuh?.let { covidSetDao.insertSembuh() }
    }

    override suspend fun addMeninggal(meninggal: List<Meninggal>?) {
        meninggal?.let { covidSetDao.insertMeninggal() }
    }
}