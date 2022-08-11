package com.example.formula1.feature_current_standing.domain.usecase

import com.example.formula1.feature_current_standing.data.mappers.toCurrent
import com.example.formula1.feature_current_standing.domain.models.Current
import com.example.formula1.feature_current_standing.domain.repo.CurrentStandingRepository
import com.example.formula1.feature_driver_standing.domain.repo.DriverStandingRepository
import com.example.formula1.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CurrentStandingUseCase @Inject constructor(
    private val currentStandingRepository: CurrentStandingRepository
) {
    operator fun invoke(): Flow<Resource<List<Current>>> = flow {
        try {
            emit(Resource.Loading<List<Current>>())
            val current = currentStandingRepository.getDriverStandings().map { it.toCurrent() }
            emit(Resource.Success<List<Current>>(current))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Current>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Current>>("Couldn't reach server. Check your internet connection."))
        }
    }
}