package com.alperen.cryptocurrency.di

import com.alperen.cryptocurrency.common.Constants.BASE_URL
import com.alperen.cryptocurrency.common.Constants.BASE_URL_TODO
import com.alperen.cryptocurrency.data.remote.CoinPaprikaApi
import com.alperen.cryptocurrency.data.remote.TodoApi
import com.alperen.cryptocurrency.data.repository.CoinRepositoryImpl
import com.alperen.cryptocurrency.data.repository.ToDoRepositoryImpl
import com.alperen.cryptocurrency.domain.repository.CoinRepository
import com.alperen.cryptocurrency.domain.repository.ToDoRepository
import com.alperen.cryptocurrency.domain.usecase.getcoins.GetCoinsUseCase
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
    fun providePaprikaApi(): CoinPaprikaApi =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(CoinPaprikaApi::class.java)

    @Provides
    @Singleton
    fun provideTodoApi(): TodoApi =
        Retrofit.Builder().baseUrl(BASE_URL_TODO).addConverterFactory(GsonConverterFactory.create())
            .build().create(TodoApi::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository = CoinRepositoryImpl(api)
    @Provides
    @Singleton
    fun provideToDoRepository(api: TodoApi): ToDoRepository = ToDoRepositoryImpl(api)


}