package com.example.formula1.feature_grandpix.data.api

import com.example.formula1.feature_grandpix.data.dto.GrandPixDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface GrandPixApi {
    @Headers(
        "X-RapidAPI-Key: 7b5273655emsh4047f04c6f9eaa7p1924a3jsnce0de28823dc",
        "X-RapidAPI-Host: formula-1-all-time-statistics.p.rapidapi.com"
    )

    @GET("all")
    suspend fun getGrandPixWinners(
    ): List<GrandPixDto>
}