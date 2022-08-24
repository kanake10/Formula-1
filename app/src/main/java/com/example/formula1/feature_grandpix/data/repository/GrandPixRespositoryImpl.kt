package com.example.formula1.feature_grandpix.data.repository


import com.example.formula1.feature_grandpix.data.api.GrandPixApi
import com.example.formula1.feature_grandpix.data.dto.GrandPixDto
import com.example.formula1.feature_grandpix.domain.repo.GrandPixRespository
import javax.inject.Inject


class GrandPixRespositoryImpl @Inject constructor(
    private val grandPixApi: GrandPixApi
) : GrandPixRespository {
    override suspend fun getGrandPix(): List<GrandPixDto> {
        return grandPixApi.getGrandPixWinners()
    }
}