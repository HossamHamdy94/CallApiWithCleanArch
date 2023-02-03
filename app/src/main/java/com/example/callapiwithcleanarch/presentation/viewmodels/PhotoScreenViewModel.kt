package com.example.callapiwithcleanarch.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.callapiwithcleanarch.data.remoteModel.PhotosResponse
import com.example.callapiwithcleanarch.data.repos.PhotosRepo
import com.example.callapiwithcleanarch.domain.GetPhotosUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoScreenViewModel  @Inject constructor (private val getPhotosUseCase: GetPhotosUseCase): ViewModel() {
    private val _photosList = MutableStateFlow<PhotosResponse> (PhotosResponse(null,null))
    val photoList: StateFlow<PhotosResponse> = _photosList

    fun getPhotos () {
        viewModelScope.launch {
          _photosList.value =   getPhotosUseCase.execute()
        }
    }
}