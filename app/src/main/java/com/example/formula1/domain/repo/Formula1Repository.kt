package com.example.formula1.domain.repo

import com.example.formula1.data.network.dto.CurrentDto
import com.example.formula1.data.network.dto.DriversDto

interface Formula1Repository {
    suspend fun getDriverStandings(): List<DriversDto>
    suspend fun getCurrentStanding(): List<CurrentDto>
}