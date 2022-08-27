package com.example.formula1.di

import com.example.formula1.feature_driver_standing.data.network.DriverStandingApi
import com.example.formula1.feature_driver_standing.data.repository.DriverStandingRepositoryImpl
import com.example.formula1.feature_driver_standing.domain.repo.DriverStandingRepository
import com.example.formula1.util.Constants
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
object DriverStandingModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(Interceptor())
            .callTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)

        return okHttpClient.build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideDriverStandingApi(okHttpClient: OkHttpClient): DriverStandingApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(DriverStandingApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDriverStandingRepository(api: DriverStandingApi): DriverStandingRepository {
        return DriverStandingRepositoryImpl(api)
    }
}