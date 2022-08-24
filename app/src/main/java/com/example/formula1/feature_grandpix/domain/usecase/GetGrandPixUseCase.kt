package com.example.formula1.feature_grandpix.domain.usecase

import com.example.formula1.feature_driver_standing.domain.models.Driver
import com.example.formula1.feature_grandpix.data.mapper.toDomain
import com.example.formula1.feature_grandpix.domain.models.GrandPix
import com.example.formula1.feature_grandpix.domain.repo.GrandPixRespository
import com.example.formula1.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGrandPixUseCase @Inject constructor(
    private val repository: GrandPixRespository
) {
    operator fun invoke(): Flow<Resource<List<GrandPix>>> = flow {
        try {
            emit(Resource.Loading<List<GrandPix>>())
            val grandpix = repository.getGrandPix().map { it.toDomain()}
            emit(Resource.Success<List<GrandPix>>(grandpix))
        } catch(e: HttpException) {
            emit(Resource.Error<List<GrandPix>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<GrandPix>>("Couldn't reach server. Check your internet connection."))
        }
    }
}