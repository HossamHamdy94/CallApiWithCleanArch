package com.example.callapiwithcleanarch.data.source.remote

import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): Any
}