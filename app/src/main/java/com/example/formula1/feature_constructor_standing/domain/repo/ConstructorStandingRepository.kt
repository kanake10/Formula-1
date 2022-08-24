package com.example.formula1.feature_constructor_standing.domain.repo

import com.example.formula1.feature_constructor_standing.data.dtos.ConstructorDto


interface ConstructorStandingRepository {
    suspend fun getConstructorStanding(): ConstructorDto
}