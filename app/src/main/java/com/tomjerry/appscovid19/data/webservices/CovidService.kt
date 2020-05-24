package com.tomjerry.appscovid19.data.webservices

import com.tomjerry.appscovid19.model.*
import retrofit2.Response
import retrofit2.http.GET

interface CovidService {

    @GET("indonesia")
    suspend fun getIndonesia(): Response<List<Indonesia>>

    @GET("indonesia/makassar")
    suspend fun getMakassar() : Response<List<Makassar>>

    @GET("indonesia/status/kasus")
    suspend fun getKasus() : Response<List<Kasus>>

    @GET("indonesia/status/sembuh")
    suspend fun getSembuh() : Response<List<Sembuh>>

    @GET("indonesia/status/meninggal")
    suspend fun getMeninggal() : Response<List<Meninggal>>
}