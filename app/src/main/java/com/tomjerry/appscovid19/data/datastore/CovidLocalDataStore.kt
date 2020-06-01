package com.tomjerry.appscovid19.data.datastore

import com.tomjerry.appscovid19.model.*

class CovidLocalDataStore : CovidDataStore {

    private lateinit var indonesia: List<Indonesia>
    private lateinit var makassar: List<Makassar>
    private lateinit var kasus: List<Kasus>
    private lateinit var meninggal: List<Meninggal>
    private lateinit var sembuh: List<Sembuh>
    private lateinit var golongan: List<Golongan>

    override suspend fun getIndonesia(): List<Indonesia>? =  if (indonesia.isNotEmpty()) indonesia else null

    override suspend fun getMakassar(): List<Makassar>? = if (makassar.isNotEmpty()) makassar else null

    override suspend fun getKasus(): List<Kasus>? = if (kasus.isNotEmpty()) kasus else null

    override suspend fun getSembuh(): List<Sembuh>? = if (sembuh.isNotEmpty()) sembuh else null

    override suspend fun getMeninggal(): List<Meninggal>? = if (meninggal.isNotEmpty()) meninggal else null

    override suspend fun getGolongan(): List<Golongan>? = if (golongan.isNotEmpty()) golongan else null

    override suspend fun addIndonesia(indonesia: List<Indonesia>?) {
        indonesia?.let { this.indonesia = it }
    }

    override suspend fun updateIndonesia(indonesia: List<Indonesia>?) {
        TODO("Not yet implemented")
    }

    override suspend fun addMakassar(makassar: List<Makassar>?) {
        makassar?.let { this.makassar = it }
    }

    override suspend fun updateMakassar(makassar: List<Makassar>?) {
        TODO("Not yet implemented")
    }

    override suspend fun addKasus(kasus: List<Kasus>?) {
        kasus?.let { this.kasus = it }
    }

    override suspend fun updateKasus(kasus: List<Kasus>?) {
        TODO("Not yet implemented")
    }

    override suspend fun addSembuh(sembuh: List<Sembuh>?) {
        sembuh?.let { this.sembuh = it }
    }

    override suspend fun updateSembuh(sembuh: List<Sembuh>?) {
        TODO("Not yet implemented")
    }

    override suspend fun addMeninggal(meninggal: List<Meninggal>?) {
        meninggal?.let { this.meninggal = it }
    }

    override suspend fun updateMeninggal(meninggal: List<Meninggal>?) {
        TODO("Not yet implemented")
    }

    override suspend fun addGolongan(golongan: List<Golongan>? , golongan1: List<Golongan>?) {
        golongan?.let { this.golongan = it}
    }
}