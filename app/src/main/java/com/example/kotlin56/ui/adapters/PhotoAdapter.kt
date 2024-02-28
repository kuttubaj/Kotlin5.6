package com.example.kotlin56.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin56.data.remote.models.Photo
import com.example.kotlin56.databinding.ItemPhotoBinding

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private var photoList = mutableListOf<Photo>()

    fun setPhoto(photoLIst: List<com.example.kotlin56.data.local.room.model.Photo>) {
        this.photoList = photoList.toMutableList()
        notifyDataSetChanged()
    }

    inner class PhotoViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(photo: Photo) {
            binding.tvItem.text = photo.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount() = photoList.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.onBind(photoList[position])
    }
}