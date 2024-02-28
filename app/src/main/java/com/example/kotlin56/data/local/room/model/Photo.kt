package com.example.kotlin56.data.local.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photo_table")

data class Photo(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)
