package com.example.formula1.feature_grandpix.domain.repo


import com.example.formula1.feature_grandpix.data.dto.GrandPixDto

interface GrandPixRespository {
    suspend fun getGrandPix(): List<GrandPixDto>
}