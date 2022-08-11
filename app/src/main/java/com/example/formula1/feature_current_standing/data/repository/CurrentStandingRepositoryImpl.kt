package com.example.formula1.feature_current_standing.data.repository

import com.example.formula1.feature_current_standing.data.api.CurrentStandingApi
import com.example.formula1.feature_current_standing.data.dto.CurrentDto
import com.example.formula1.feature_current_standing.domain.repo.CurrentStandingRepository
import com.example.formula1.feature_driver_standing.data.remote.DriverStandingApi
import com.example.formula1.feature_driver_standing.data.remote.dto.DriversDto
import com.example.formula1.feature_driver_standing.domain.repo.DriverStandingRepository
import javax.inject.Inject

class CurrentStandingRepositoryImpl @Inject constructor(
    private val currentStandingApi: CurrentStandingApi
) : CurrentStandingRepository {
    override suspend fun getDriverStandings(): List<CurrentDto> {
        return currentStandingApi.getCurrentStanding()
    }
}