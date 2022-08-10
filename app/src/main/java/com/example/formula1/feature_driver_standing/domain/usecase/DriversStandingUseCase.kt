package com.example.formula1.feature_driver_standing.domain.usecase

import com.example.formula1.feature_driver_standing.data.remote.mapper.toDriver
import com.example.formula1.feature_driver_standing.domain.models.Driver
import com.example.formula1.feature_driver_standing.domain.repo.DriverStandingRepository
import com.example.formula1.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DriversStandingUseCase @Inject constructor(
    private val repository: DriverStandingRepository
) {
    operator fun invoke(): Flow<Resource<List<Driver>>> = flow {
        try {
            emit(Resource.Loading<List<Driver>>())
            val drivers = repository.getDriverStandings().map { it.toDriver()}
            emit(Resource.Success<List<Driver>>(drivers))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Driver>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Driver>>("Couldn't reach server. Check your internet connection."))
        }
    }
}