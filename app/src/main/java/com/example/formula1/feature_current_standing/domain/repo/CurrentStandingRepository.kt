package com.example.formula1.feature_current_standing.domain.repo

import com.example.formula1.feature_current_standing.data.dto.CurrentDto


interface CurrentStandingRepository {
    suspend fun getDriverStandings(): List<CurrentDto>
}