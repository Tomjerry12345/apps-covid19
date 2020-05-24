package com.tomjerry.appscovid19.data.webservices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApp {

private const val BASE_URL = "http://api-covid19-tomjerry.herokuapp.com/"

    private val client = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val COVID_SERVICE: CovidService = client.create(CovidService::class.java)
}