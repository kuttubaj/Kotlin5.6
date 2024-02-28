package com.example.kotlin56.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kotlin56.data.remote.models.Photo
import com.example.kotlin56.data.repositories.LocalRepositories
import com.example.kotlin56.data.repositories.PhotoRepositories

class ViewModel: ViewModel() {
    private val photoRepositories = PhotoRepositories()
    private val localRepositories = LocalRepositories()


    fun createPhoto(
        photo: com.example.kotlin56.data.local.room.model.Photo,
        onSuccess: (photo: Photo) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        photoRepositories.createPhoto(
            photo = photo,
            onResponse = onSuccess
        ) { message, t ->
            val message = t.message ?: "No text!"
            onFailure(message)

        }
    }

    fun updatePhoto(
        photoId: Int,
        photo: com.example.kotlin56.data.local.room.model.Photo,
        onSuccess: (photo: Photo) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        photoRepositories.updatePhoto(
           photoId = photoId,
            photo = photo,
            onResponse = onSuccess
        ) { message, t ->
            val message = t.message ?: "No text!"
            Log.e("createPost", message)
            onFailure(message)


        }
    }

    fun editPhoto(
        title: String,
        onSuccess: (photo: Photo) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        photoRepositories.editPhoto(
            photoId = title,
            onResponse = onSuccess
        ) { message, t ->
            val message = t.message ?: "Unknown error!"
            Log.e("createPost", message)
            onFailure(message)

        }
    }

    fun deletePhoto(
        photoId: Int,
        photo: com.example.kotlin56.data.local.room.model.Photo,
        onSuccess: (photo: Photo) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        photoRepositories.deletePhoto(
            photoId = photoId,
            photo = photo,
            onResponse = onSuccess
        ) { message, t ->
            val message = t.message ?: "Unknown error!"
            Log.e("createPost", message)
            onFailure(message)
        }
    }

    fun addData(photo: Photo) {
        localRepositories.addData(photo)
    }

    //получение с room
    fun fetchData(): List<com.example.kotlin56.data.local.room.model.Photo> {
        return localRepositories.fatchData()
    }
}