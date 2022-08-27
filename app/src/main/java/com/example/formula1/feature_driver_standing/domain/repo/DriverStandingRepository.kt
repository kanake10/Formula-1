package com.example.formula1.feature_driver_standing.domain.repo

import com.example.formula1.feature_driver_standing.data.dto.DriversDto


interface DriverStandingRepository {
    suspend fun getDriverStandings(): List<DriversDto>
}