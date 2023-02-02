package com.example.callapiwithcleanarch.data.repos

import com.example.callapiwithcleanarch.data.source.RemoteDataSource
import com.example.callapiwithcleanarch.data.source.RemoteDataSourceImp
import javax.inject.Inject

class PhotosRepo @Inject constructor(private val dataSource: RemoteDataSource) {
  suspend  fun getPhotos() {
      dataSource.getPhotos()
    }
}