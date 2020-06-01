package com.tomjerry.appscovid19.data.datastore

import android.util.Log
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

    override suspend fun getGolongan(): List<Golongan>? {
        val response = covidSetDao.getGolongan()
        return if (response.isEmpty()) null else response
    }

    override suspend fun addIndonesia(indonesia: List<Indonesia>?) {
        indonesia?.let { covidSetDao.insertIndonesia(it) }
    }

    override suspend fun updateIndonesia(indonesia: List<Indonesia>?) {
        indonesia?.let { covidSetDao.updateIndonesia(it) }
    }

    override suspend fun addMakassar(makassar: List<Makassar>?) {
        makassar?.let { covidSetDao.inserMakassar(it) }
    }

    override suspend fun updateMakassar(makassar: List<Makassar>?) {
        makassar?.let { covidSetDao.updateMakassar(it) }
    }

    override suspend fun addKasus(kasus: List<Kasus>?) {
        kasus?.let { covidSetDao.insertKasus(it) }
    }

    override suspend fun updateKasus(kasus: List<Kasus>?) {
        kasus?.let { covidSetDao.updateKasus(it) }
    }

    override suspend fun addSembuh(sembuh: List<Sembuh>?) {
        sembuh?.let { covidSetDao.insertSembuh(it) }
    }

    override suspend fun updateSembuh(sembuh: List<Sembuh>?) {
        sembuh?.let { covidSetDao.updateSembuh(it) }
    }

    override suspend fun addMeninggal(meninggal: List<Meninggal>?) {
        meninggal?.let { covidSetDao.insertMeninggal(it) }
    }

    override suspend fun updateMeninggal(meninggal: List<Meninggal>?) {
        meninggal?.let { covidSetDao.updateMeninggal(it) }
    }

    override suspend fun addGolongan(golongan: List<Golongan>? , golongan1: List<Golongan>?) {
        Log.println(Log.ASSERT , "cek" , "$golongan")

        if(golongan1 == null) {
            golongan?.let {
                covidSetDao.insertGolongan(it)
            }
        } else {
            golongan?.let {
                covidSetDao.updateGolongan(it)
            }
        }
    }
}