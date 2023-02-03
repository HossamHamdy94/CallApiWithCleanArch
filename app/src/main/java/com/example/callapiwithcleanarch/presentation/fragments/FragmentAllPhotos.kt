package com.example.callapiwithcleanarch.presentation.fragments

import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.callapiwithcleanarch.R
import com.example.callapiwithcleanarch.base.BaseFragment
import com.example.callapiwithcleanarch.presentation.adapters.AllPhotosAdapter
import com.example.callapiwithcleanarch.viewmodels.PhotoScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_allphotos.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentAllPhotos : BaseFragment(R.layout.fragment_allphotos) {

    private val mAdapter: AllPhotosAdapter by lazy {
        AllPhotosAdapter()
    }

    private val viewModel: PhotoScreenViewModel by viewModels()

    override fun init() {
        super.init()
        viewModel.getPhotos()
        photosRV.layoutManager =  LinearLayoutManager(context , LinearLayoutManager.VERTICAL,false)
        photosRV.adapter = mAdapter


    }


    override fun subscribe() {

        lifecycleScope.launch {
            viewModel.photoList.collect {
                if (it.stat == "ok"){
                    it.photos?.photo?.let { it1 ->
                        Log.d("Hossam",it.toString())
                        mAdapter.submitList(it1)

                    }
                }

            }

        }
    }


}