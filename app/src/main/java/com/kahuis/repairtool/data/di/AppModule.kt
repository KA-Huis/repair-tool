package com.kahuis.repairtool.data.di

import com.kahuis.repairtool.common.Constants.BASE_URL
import com.kahuis.repairtool.data.remote.RepairApi
import com.kahuis.repairtool.data.repository.RepairRepositoryImpl
import com.kahuis.repairtool.domain.repository.RepairRepository
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
    fun provideRepairApi(): RepairApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL) //is MOCK needed, check constants
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RepairApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepairRepository(api: RepairApi): RepairRepository {
        return RepairRepositoryImpl(api)
    }
}