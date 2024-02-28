package com.example.kotlin56.data.repositories

import com.example.kotlin56.data.remote.RetrofitClient
import com.example.kotlin56.data.remote.models.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoRepositories {

    private val apiService = RetrofitClient.photosApiService


    fun createPhoto(
        photo: Photo,
        onResponse: (photo:Photo) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        apiService.createPhoto(photo).enqueue(object : Callback<Photo> {
            override fun onResponse(
                call: Call<Photo>,
                response: Response<Photo>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Photo>, t: Throwable) {
                onFailure(t.message ?: "no text!", t)
            }
        })
    }

    fun updatePhoto(
        photoId: Int,
        photo: Photo,
        onResponse: (photo: Photo) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        apiService.updatePhoto(photoId = photoId, photo = photo).enqueue(object : Callback<Photo> {
            override fun onResponse(
                call: Call<Photo>,
                response: Response<Photo>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }

            }

            override fun onFailure(call: Call<Photo>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })

    }

    fun editPhoto(
        photoId: String,
        onResponse: (photo: Photo) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        apiService.editPhoto(photoId).enqueue(object : Callback<Photo> {
            override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }

            }

            override fun onFailure(call: Call<Photo>, t: Throwable) {
                onFailure(t.message ?: "No text!", t)
            }
        })
    }

    fun deletePhoto(
        photoId: Int,
        photo: Photo,
        onResponse: (photo:Photo) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        apiService.deletePhoto(photoId = photoId).enqueue(object : Callback<Photo> {
            override fun onResponse(
                call: Call<Photo>,
                response: Response<Photo>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Photo>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })
    }
}