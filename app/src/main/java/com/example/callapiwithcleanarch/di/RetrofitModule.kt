package com.example.callapiwithcleanarch.di


import com.example.callapiwithcleanarch.base.CoroutineScopeDispatchers
import com.example.callapiwithcleanarch.base.ICoroutineScopeDispatchers
import com.example.callapiwithcleanarch.data.source.RemoteDataSource
import com.example.callapiwithcleanarch.data.source.RemoteDataSourceImp
import com.example.callapiwithcleanarch.data.source.remote.ApiService
import com.example.callapiwithcleanarch.utils.Constants
import com.example.callapiwithcleanarch.utils.NetworkHelper.provideOkHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object RetrofitModule {



    @Provides
    fun provideApiSerVice(): ApiService {
        return Retrofit.Builder()
            .client(provideOkHttpClient())
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }

    @Provides
    @Singleton
    fun provideICoroutineScopeDispatchers() :ICoroutineScopeDispatchers = CoroutineScopeDispatchers()
    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: ApiService,iCoroutineScopeDispatchers: ICoroutineScopeDispatchers): RemoteDataSource = RemoteDataSourceImp (apiService,iCoroutineScopeDispatchers)

}