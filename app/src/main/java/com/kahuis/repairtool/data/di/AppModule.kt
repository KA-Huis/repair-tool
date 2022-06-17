package com.kahuis.repairtool.data.di

import com.kahuis.repairtool.common.Constants.MOCK_API_URL
import com.kahuis.repairtool.data.remote.ReparationApi
import com.kahuis.repairtool.data.repository.ReparationRepositoryImpl
import com.kahuis.repairtool.domain.repository.ReparationRepository
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
    fun provideRepairApi(): ReparationApi {
        return Retrofit.Builder()
            .baseUrl(MOCK_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ReparationApi::class.java)
    }

    @Provides
    @Singleton
    fun provideReparationRepository(api: ReparationApi): ReparationRepository {
        return ReparationRepositoryImpl(api)
    }
}