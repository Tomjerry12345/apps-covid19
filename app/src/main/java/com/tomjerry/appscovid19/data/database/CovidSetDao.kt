package com.tomjerry.appscovid19.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tomjerry.appscovid19.model.*

@Dao
interface CovidSetDao {
    @Query("SELECT * FROM Indonesia")
    suspend fun getIndonesia(): List<Indonesia>
    @Query("SELECT * FROM Makassar")
    suspend fun getMakassar(): List<Makassar>
    @Query("SELECT * FROM Kasus")
    suspend fun getKasus(): List<Kasus>
    @Query("SELECT * FROM Sembuh")
    suspend fun getSembuh(): List<Sembuh>
    @Query("SELECT * FROM Meninggal")
    suspend fun getMeninggal(): List<Meninggal>
    @Query("SELECT * FROM Golongan")
    suspend fun getGolongan(): List<Golongan>

    @Insert
    suspend fun insertIndonesia(indonesia : List<Indonesia>)
    @Insert
    suspend fun inserMakassar(makassar : List<Makassar>)
    @Insert
    suspend fun insertKasus(kasus : List<Kasus>)
    @Insert
    suspend fun insertSembuh(sembuh : List<Sembuh>)
    @Insert
    suspend fun insertMeninggal(meninggal : List<Meninggal>)
    @Insert
    suspend fun insertGolongan(golongan: List<Golongan>)

    @Update
    suspend fun updateGolongan(golongan: List<Golongan>)
    @Update
    suspend fun updateIndonesia(indonesia: List<Indonesia>)
    @Update
    suspend fun updateMakassar(makassar: List<Makassar>)
    @Update
    suspend fun updateKasus(kasus: List<Kasus>)
    @Update
    suspend fun updateMeninggal(meninggal: List<Meninggal>)
    @Update
    suspend fun updateSembuh(sembuh: List<Sembuh>)
}