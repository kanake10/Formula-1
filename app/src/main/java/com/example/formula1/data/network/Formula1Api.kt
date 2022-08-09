package com.example.formula1.data.network

import com.example.formula1.data.network.dto.CurrentDto
import com.example.formula1.data.network.dto.DriversDto
import com.example.formula1.util.Constants.YEAR
import retrofit2.http.GET
import retrofit2.http.Query

interface Formula1Api{

    @GET("driverStanding")
    suspend fun getDriverStanding(
        @Query("year") year: Int = YEAR
    ): List<DriversDto>

    @GET("current")
    suspend fun getCurrentStanding(): List<CurrentDto>
}