package com.example.composepritices.modle.di

import android.content.Context
import androidx.room.Room
import com.example.composepritices.db.AppDataBase
import com.example.composepritices.model.network.API
import com.example.composepritices.modle.commom.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideClient(
        loggingInterceptor: HttpLoggingInterceptor
    ):OkHttpClient{
        return OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): API {
        return retrofit.create(API::class.java)
    }

    @Singleton
    @Provides
    fun loggingInterceptor():HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            level=HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context:Context):AppDataBase{
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "Article_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideDao(dao:AppDataBase)=dao.productDao()
}