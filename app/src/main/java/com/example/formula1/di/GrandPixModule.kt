package com.example.formula1.di


import com.example.formula1.feature_grandpix.data.api.GrandPixApi
import com.example.formula1.feature_grandpix.data.repository.GrandPixRespositoryImpl
import com.example.formula1.feature_grandpix.domain.repo.GrandPixRespository
import com.example.formula1.util.Constants.GRANDPIX_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GrandPixModule {

    @Provides
    @Singleton
    fun provideGrandPixAPI(): GrandPixApi {
        return Retrofit.Builder()
            .baseUrl(GRANDPIX_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GrandPixApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGrandPixRepository(
        grandPixApi: GrandPixApi
    ): GrandPixRespository {
        return GrandPixRespositoryImpl(
            grandPixApi
        )
    }


}