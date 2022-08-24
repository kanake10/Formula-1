package com.example.formula1.feature_grandpix.data.mapper

import com.example.formula1.feature_grandpix.data.dto.GrandPixDto
import com.example.formula1.feature_grandpix.domain.models.GrandPix


fun GrandPixDto.toDomain():GrandPix{
    return GrandPix(
        driver, grandPrix, laps, team
    )
}