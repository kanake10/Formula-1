package com.example.formula1.data.network

import com.example.formula1.data.network.dto.DriversDto
import com.example.formula1.util.Constants.YEAR
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Formula1Api{
    @Headers(
        "X-RapidAPI-Key: 7b5273655emsh4047f04c6f9eaa7p1924a3jsnce0de28823dc",
        "X-RapidAPI-Host: formula-18.p.rapidapi.com"
            )
    @GET("driverStanding/{year}")
    suspend fun getDriverStanding(
        @Path("year") year: Int = YEAR
    ): List<DriversDto>
}