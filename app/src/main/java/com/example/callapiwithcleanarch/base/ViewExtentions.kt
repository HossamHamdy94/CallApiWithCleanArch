package com.example.callapiwithcleanarch.base

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import io.reactivex.functions.Action
import java.io.File



fun ImageView.loadFromFilePath(
    path: String
) {
    setImageBitmap(
        BitmapFactory.decodeFile(File(path).absolutePath)
    )
}

fun ImageView.loadFromUrl(
    url: String,
    progressLoading: ProgressBar? = null,
    placeholderResId: Int = -1
) {
    progressLoading?.visibility = View.VISIBLE
    Glide.with(context)
        .load(url)
        .listener(object : RequestListener<Drawable> {
            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                progressLoading?.visibility = View.GONE
                return false
            }

            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                progressLoading?.visibility = View.GONE
                return false
            }
        })
        .apply(
            RequestOptions()
                .placeholder(if (placeholderResId < 0) android.R.color.transparent else placeholderResId)
                .centerInside()
        )
        .into(this)
}


