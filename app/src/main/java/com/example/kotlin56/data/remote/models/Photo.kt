package com.example.kotlin56.data.remote.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("body") val body: String,
    @SerializedName("id") @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @SerializedName("title") val title: String,
    @SerializedName("userId") val userId: Int
)