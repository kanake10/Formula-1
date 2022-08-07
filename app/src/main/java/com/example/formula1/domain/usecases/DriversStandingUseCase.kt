package com.example.formula1.domain.usecases

import com.example.formula1.data.network.dto.toDriver
import com.example.formula1.domain.models.Driver
import com.example.formula1.domain.repo.Formula1Repository
import com.example.formula1.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DriversStandingUseCase @Inject constructor(
    private val repository: Formula1Repository
) {
    operator fun invoke(): Flow<Resource<List<Driver>>> = flow {
        try {
            emit(Resource.Loading<List<Driver>>())
            val drivers = repository.getDriverStandings().map { it.toDriver() }
            emit(Resource.Success<List<Driver>>(drivers))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Driver>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Driver>>("Couldn't reach server. Check your internet connection."))
        }
    }
}