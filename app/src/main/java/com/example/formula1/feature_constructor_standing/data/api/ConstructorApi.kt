package com.example.formula1.feature_constructor_standing.data.api

import com.example.formula1.feature_constructor_standing.data.dtos.ConstructorDto
import com.example.formula1.util.Constants.CONSTRUCTOR_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ConstructorApi {

    @Headers(
        "X-RapidAPI-Key: 7b5273655emsh4047f04c6f9eaa7p1924a3jsnce0de28823dc",
        "X-RapidAPI-Key: formula-1-standings.p.rapidapi.com",
    )
    @GET(CONSTRUCTOR_ENDPOINT)
    suspend fun getConstructorStanding(
    ): ConstructorDto
}