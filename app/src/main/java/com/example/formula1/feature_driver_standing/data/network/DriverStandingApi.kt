package com.example.formula1.feature_driver_standing.data.network

import com.example.formula1.feature_driver_standing.data.dto.DriversDto
import com.example.formula1.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface DriverStandingApi {

    @GET("driverStanding")
    suspend fun getDriverStanding(
        @Query("year") year: Int = Constants.YEAR
    ): List<DriversDto>
}