package com.example.formula1.feature_constructor_standing.data.repository

import com.example.formula1.feature_constructor_standing.data.api.ConstructorApi
import com.example.formula1.feature_constructor_standing.data.dtos.ConstructorDto
import com.example.formula1.feature_constructor_standing.data.dtos.ResultDto
import com.example.formula1.feature_constructor_standing.domain.repo.ConstructorStandingRepository
import javax.inject.Inject

class ConstructorStandingRepositoryImpl @Inject constructor(
    private val constructorApi: ConstructorApi
): ConstructorStandingRepository {
    override suspend fun getConstructorStanding(): ConstructorDto {
        return constructorApi.getConstructorStanding()
    }

}