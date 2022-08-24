package com.example.formula1.di

import com.example.formula1.feature_constructor_standing.data.api.ConstructorApi
import com.example.formula1.feature_constructor_standing.data.repository.constructorStandingRepositoryImpl
import com.example.formula1.feature_constructor_standing.domain.repo.ConstructorStandingRepository
import com.example.formula1.feature_constructor_standing.domain.usecase.ConstructorStandingUseCase
import com.example.formula1.feature_driver_standing.data.remote.DriverStandingApi
import com.example.formula1.feature_driver_standing.data.repository.DriverStandingRepositoryImpl
import com.example.formula1.feature_driver_standing.domain.repo.DriverStandingRepository
import com.example.formula1.util.Constants
import com.example.formula1.util.Constants.CONSTRUCTOR_BASE_URL
import com.example.formula1.util.ConstructorInterceptor
import com.example.formula1.util.Interceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import java.util.concurrent.TimeUnit

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
        return constructorStandingRepositoryImpl(
            api
        )
    }

    @Provides
    @Singleton
    fun provideConstructorStandingUseCase(constructorStandingRepository: ConstructorStandingRepository): ConstructorStandingUseCase {
        return ConstructorStandingUseCase(constructorStandingRepository)
    }

}