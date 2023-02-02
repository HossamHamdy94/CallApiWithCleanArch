package com.example.callapiwithcleanarch.data.source

interface RemoteDataSource {

    suspend fun getPhotos() : Any
}