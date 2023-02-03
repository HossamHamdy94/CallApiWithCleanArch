package com.example.callapiwithcleanarch.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.callapiwithcleanarch.R
import com.example.callapiwithcleanarch.base.BaseRecyclerAdapter
import com.example.callapiwithcleanarch.data.remoteModel.Photo
import kotlinx.android.synthetic.main.photo_item.view.*

class AllPhotosAdapter: ListAdapter<Photo, AllPhotosAdapter.ViewHolder>(ViewHolder) {







    class ViewHolder(
        private val itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Photo) {
            itemView.photoTiltleTv.text = item.owner
            Log.d("Hossam",item.title)

        }



         companion   object : DiffUtil.ItemCallback<Photo>() {

                override fun areItemsTheSame(
                    oldItem: Photo,
                    newItem: Photo
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Photo,
                    newItem: Photo
                ): Boolean {
                    return oldItem == newItem
                }

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllPhotosAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AllPhotosAdapter.ViewHolder, position: Int) {
        val item = currentList[position]
        Log.d("Hossam",item.title)

        holder.bind(item)
    }
}