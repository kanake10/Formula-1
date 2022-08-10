package com.example.formula1.di

import com.example.formula1.feature_driver_standing.data.remote.DriverStandingApi
import com.example.formula1.feature_driver_standing.data.repository.DriverStandingRepositoryImpl
import com.example.formula1.feature_driver_standing.domain.repo.DriverStandingRepository
import com.example.formula1.feature_driver_standing.domain.usecase.DriversStandingUseCase
import com.example.formula1.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DriverStandingModule {

    @Provides
    @Singleton
    fun provideProductsApiService(): DriverStandingApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DriverStandingApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDriverStandingRepository(
        driverStandingApi: DriverStandingApi
    ): DriverStandingRepository {
        return DriverStandingRepositoryImpl(
            driverStandingApi
        )
    }

    @Provides
    @Singleton
    fun provideDriversStandingUseCase(driverStandingRepository: DriverStandingRepository): DriversStandingUseCase {
        return DriversStandingUseCase(driverStandingRepository)
    }

}