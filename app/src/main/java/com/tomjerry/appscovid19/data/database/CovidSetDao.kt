package com.tomjerry.appscovid19.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
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

//    @Query("DELETE FROM PokemonSet")
//    suspend fun deleteIndonesia()

    @Insert
    suspend fun insertIndonesia(vararg indonesia: Indonesia)
    @Insert
    suspend fun inserMakassar(vararg makassar: Makassar)
    @Insert
    suspend fun insertKasus(vararg kasus: Kasus)
    @Insert
    suspend fun insertSembuh(vararg sembuh: Sembuh)
    @Insert
    suspend fun insertMeninggal(vararg meninggal: Meninggal)
}