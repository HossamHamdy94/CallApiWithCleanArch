package com.example.callapiwithcleanarch.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.callapiwithcleanarch.data.repos.PhotosRepo

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoScreenViewModel  @Inject constructor (private val repo:PhotosRepo): ViewModel() {


    fun getPhotos () {
        viewModelScope.launch {
            repo.getPhotos()
        }
    }
}