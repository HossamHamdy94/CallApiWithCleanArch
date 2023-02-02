package com.example.callapiwithcleanarch.data.source

import com.example.callapiwithcleanarch.data.source.remote.ApiService
import javax.inject.Inject

class RemoteDataSourceImp  @Inject constructor( private  val api : ApiService ): RemoteDataSource {
    override suspend fun getPhotos(): Any {
        return api.getPhotos()
    }
}