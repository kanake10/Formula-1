package com.example.formula1.data.network

import com.example.formula1.feature_driver_standing.data.remote.dto.CurrentDto
import retrofit2.http.GET

interface Formula1Api{


    @GET("current")
    suspend fun getCurrentStanding(): List<CurrentDto>
}