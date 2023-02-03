package com.example.callapiwithcleanarch.domain

import com.example.callapiwithcleanarch.data.remoteModel.PhotosResponse
import com.example.callapiwithcleanarch.data.repos.PhotosRepo
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(val repo: PhotosRepo) : BaseSuspendableUseCase.UseCaseWithoutParams<PhotosResponse> {
    override suspend fun execute(): PhotosResponse {
        return repo.getPhotos()

    }
}