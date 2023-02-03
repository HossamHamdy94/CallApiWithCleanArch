package com.example.callapiwithcleanarch.data.source.remote

import retrofit2.http.GET

interface ApiService {
    @GET("?method=flickr.photos.getRecent&api_key=22d59dcd958e6a6f089b1949ba72ca0e&format=json&nojsoncallback=1&auth_token=72157720872478509-1b93c1b27335250e&api_sig=c26ca37f18b184c1944133f7f2a8aa9f")
    suspend fun getPhotos(): Any
}



