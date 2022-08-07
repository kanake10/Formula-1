package com.example.formula1.di

import com.example.formula1.data.network.Formula1Api
import com.example.formula1.data.network.repo.Formula1RepositoryImpl
import com.example.formula1.domain.repo.Formula1Repository
import com.example.formula1.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFormula1Api(): Formula1Api {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Formula1Api::class.java)
    }

    @Provides
    @Singleton
    fun provideFormula1Repository(api: Formula1Api): Formula1Repository {
        return Formula1RepositoryImpl(api)
    }
}