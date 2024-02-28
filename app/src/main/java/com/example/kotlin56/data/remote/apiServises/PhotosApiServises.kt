package com.example.kotlin56.data.remote.apiServises


import com.example.kotlin56.data.remote.models.Photo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

private const val JSON_KEY = "/photos"

interface PhotosApiService {
    @POST(JSON_KEY)
    fun createPhoto(
        @Body photo: Photo
    ): Call<Photo>

    @PUT("$JSON_KEY/{photoId}")
    fun updatePhoto(
        @Path("photoId") photoId: Int,
        @Body photo: Photo
    ): Call<Photo>

    @FormUrlEncoded
    @PATCH("$JSON_KEY/{title}")
    fun editPhoto(
        @Field("title") title: String
    ): Call<Photo>

    @DELETE("$JSON_KEY/{postId}")
    fun deletePhoto(
        @Path("photoId") photoId: Int,
    ): Call<Photo>
}