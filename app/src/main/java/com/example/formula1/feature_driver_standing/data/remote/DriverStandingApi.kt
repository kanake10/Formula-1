package com.example.formula1.feature_driver_standing.data.remote

import com.example.formula1.feature_driver_standing.data.remote.dto.DriversDto
import com.example.formula1.util.Constants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DriverStandingApi {
    @Headers(
        "X-RapidAPI-Key: 7b5273655emsh4047f04c6f9eaa7p1924a3jsnce0de28823dc",
        "X-RapidAPI-Host: formula-18.p.rapidapi.com"
    )
    @GET("driverStanding")
    suspend fun getDriverStanding(
        @Query("year") year: Int = Constants.YEAR
    ): List<DriversDto>
}