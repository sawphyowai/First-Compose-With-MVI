package com.example.composepritices.modle.di

import com.example.composepritices.repository.NetworkRepositoryImpl
import com.example.composepritices.repository.NetworkRepositoryService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryImpl {
    @Binds
    fun provideServiceRepository(impl: NetworkRepositoryImpl) : NetworkRepositoryService
}