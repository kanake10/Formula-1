package com.example.formula1.data.network.repo

import com.example.formula1.data.network.Formula1Api
import com.example.formula1.data.network.dto.DriversDto
import com.example.formula1.domain.repo.Formula1Repository
import javax.inject.Inject

class Formula1RepositoryImpl @Inject constructor(
    private val api: Formula1Api
) : Formula1Repository {
    override suspend fun getDriverStandings(): List<DriversDto> {
        return api.getDriverStanding()
    }


}