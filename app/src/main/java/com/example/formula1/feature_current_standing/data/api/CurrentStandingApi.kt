package com.example.formula1.feature_current_standing.data.api

import com.example.formula1.feature_current_standing.data.dto.CurrentDto
import retrofit2.http.GET

interface CurrentStandingApi {
    @GET("current")
    suspend fun getCurrentStanding(): List<CurrentDto>
}