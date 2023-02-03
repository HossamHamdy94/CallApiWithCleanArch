package com.example.callapiwithcleanarch.presentation.activties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.callapiwithcleanarch.R
import com.example.callapiwithcleanarch.viewmodels.PhotoScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


     val viewModel: PhotoScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUsers()


    }
    private fun  getUsers() {
        viewModel.getPhotos()
    }


}