package com.example.formula1.data.network

import com.example.formula1.data.network.dto.DriversDto
import com.example.formula1.util.Constants.YEAR
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Formula1Api{
    @Headers(
        "X-RapidAPI-Key: 7b5273655emsh4047f04c6f9eaa7p1924a3jsnce0de28823dc",
        "X-RapidAPI-Host: formula-18.p.rapidapi.com"
            )
    @GET("driverStanding")
    suspend fun getDriverStanding(
        @Query("year") year: Int = YEAR
    ): List<DriversDto>
}