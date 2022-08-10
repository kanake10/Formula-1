package com.example.formula1.domain.usecases

import com.example.formula1.feature_driver_standing.domain.models.Current
import com.example.formula1.feature_driver_standing.domain.repo.DriverStandingRepository
import com.example.formula1.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject



class CurrentStandingUseCase @Inject constructor(
    private val repository: DriverStandingRepository
) {
    operator fun invoke(): Flow<Resource<List<Current>>> = flow {
        try {
            emit(Resource.Loading<List<Current>>())
            val current = repository.getCurrentStanding().map { com.example.formula1.feature_driver_standing.data.remote.mapper.toCurrent() }
            emit(Resource.Success<List<Current>>(current))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Current>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Current>>("Couldn't reach server. Check your internet connection."))
        }
    }
}