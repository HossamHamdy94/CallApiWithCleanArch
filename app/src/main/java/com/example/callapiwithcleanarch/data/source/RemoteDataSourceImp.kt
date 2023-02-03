package com.example.callapiwithcleanarch.data.source

import com.example.callapiwithcleanarch.base.ICoroutineScopeDispatchers
import com.example.callapiwithcleanarch.data.remoteModel.PhotosResponse
import com.example.callapiwithcleanarch.data.source.remote.ApiService
import com.example.callapiwithcleanarch.utils.handleHttpException
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val api: ApiService,
    private val coroutineScopeDispatchers: ICoroutineScopeDispatchers,

    ) : RemoteDataSource {
    override suspend fun getPhotos(): PhotosResponse {


        return withContext(coroutineScopeDispatchers.IO) {
            try {
                 api.getPhotos()
            } catch (e: Exception) {
                throw e.handleHttpException()
            }
        }
    }
}