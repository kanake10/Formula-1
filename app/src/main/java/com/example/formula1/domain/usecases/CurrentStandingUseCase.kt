package com.example.formula1.domain.usecases

import com.example.formula1.data.network.mapper.toCurrent
import com.example.formula1.data.network.mapper.toDriver
import com.example.formula1.domain.models.Current
import com.example.formula1.domain.models.Driver
import com.example.formula1.domain.repo.Formula1Repository
import com.example.formula1.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject



class CurrentStandingUseCase @Inject constructor(
    private val repository: Formula1Repository
) {
    operator fun invoke(): Flow<Resource<List<Current>>> = flow {
        try {
            emit(Resource.Loading<List<Current>>())
            val current = repository.getCurrentStanding().map { it.toCurrent() }
            emit(Resource.Success<List<Current>>(current))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Current>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Current>>("Couldn't reach server. Check your internet connection."))
        }
    }
}