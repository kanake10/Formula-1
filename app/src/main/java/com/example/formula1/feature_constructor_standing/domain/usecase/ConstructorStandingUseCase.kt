package com.example.formula1.feature_constructor_standing.domain.usecase


import com.example.formula1.feature_constructor_standing.data.mapper.toDomain
import com.example.formula1.feature_constructor_standing.domain.model.Result
import com.example.formula1.feature_constructor_standing.domain.repo.ConstructorStandingRepository
import com.example.formula1.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ConstructorStandingUseCase @Inject constructor(
    private val repository: ConstructorStandingRepository
) {
   operator fun invoke():Flow<Resource<List<Result>>> = flow {
       try {
           emit(Resource.Loading())
           val constructors = repository.getConstructorStanding().results.map { it.toDomain() }
           emit(Resource.Success(constructors))
       } catch (e :HttpException) {
           emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
       } catch(e: IOException) {
           emit(Resource.Error("Couldn't reach server. Check your internet connection."))
       }
   }
}