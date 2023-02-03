package com.example.callapiwithcleanarch.data.source

import com.example.callapiwithcleanarch.data.remoteModel.PhotosResponse

interface RemoteDataSource {

    suspend fun getPhotos() : PhotosResponse
}