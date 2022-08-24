package com.example.formula1.di

import com.example.formula1.feature_constructor_standing.data.api.ConstructorApi
import com.example.formula1.feature_constructor_standing.data.repository.ConstructorStandingRepositoryImpl
import com.example.formula1.feature_constructor_standing.domain.repo.ConstructorStandingRepository
import com.example.formula1.feature_constructor_standing.domain.usecase.ConstructorStandingUseCase
import com.example.formula1.util.Constants.CONSTRUCTOR_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ConstructorStandingModule {

    @Provides
    @Singleton
    fun provideConstructorApi(): ConstructorApi {
        return Retrofit.Builder()
            .baseUrl(CONSTRUCTOR_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ConstructorApi::class.java)
    }

    @Provides
    @Singleton
    fun provideConstructorRepository(
        api: ConstructorApi
    ): ConstructorStandingRepository {
        return ConstructorStandingRepositoryImpl(
            api
        )
    }

    @Provides
    @Singleton
    fun provideConstructorStandingUseCase(constructorStandingRepository: ConstructorStandingRepository): ConstructorStandingUseCase {
        return ConstructorStandingUseCase(constructorStandingRepository)
    }

}