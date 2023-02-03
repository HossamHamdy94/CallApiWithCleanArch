package com.example.callapiwithcleanarch.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment {

    constructor(): super()

    constructor(layoutId: Int): super(layoutId)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        subscribe()
    }

    open fun init() {}

    open fun subscribe() {}
}



