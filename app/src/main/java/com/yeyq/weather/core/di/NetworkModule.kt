package com.yeyq.weather.core.di

import com.yeyq.weather.BuildConfig
import com.yeyq.weather.core.BASE_URL
import com.yeyq.weather.core.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class NetworkModule {
    companion object {
        @Provides
        @Singleton
        internal fun provideLoggingInterceptor() = HttpLoggingInterceptor()
            .apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            }

        @Provides
        @Singleton
        internal fun provideOkHttpClient(logging: HttpLoggingInterceptor) = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        @Provides
        @Singleton
        internal fun provideGsonConverterFactory() = GsonConverterFactory.create()

        @Provides
        @Singleton
        internal fun provideRetrofit(
            okHttpClient: OkHttpClient,
            gsonConverterFactory: GsonConverterFactory
        ) = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()

        @Provides
        @Singleton
        internal fun provideApi(retrofit: Retrofit) = retrofit.create(WeatherApi::class.java)
    }
}