package com.example.formula1.feature_driver_standing.data.repository

import com.example.formula1.feature_driver_standing.data.network.DriverStandingApi
import com.example.formula1.feature_driver_standing.data.dto.DriversDto
import com.example.formula1.feature_driver_standing.domain.repo.DriverStandingRepository
import javax.inject.Inject

class DriverStandingRepositoryImpl @Inject constructor(
    private val driverStandingApi: DriverStandingApi
) : DriverStandingRepository {
    override suspend fun getDriverStandings(): List<DriversDto> {
        return driverStandingApi.getDriverStanding()
    }

}