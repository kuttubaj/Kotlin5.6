package com.example.kotlin56.data.repositories

import com.example.kotlin56.data.remote.models.Photo
import com.example.kotlin56.utils.App

class LocalRepositories {
    fun fatchData() = App.db.dao.getAllPhoto()

    fun addData(photo: Photo) {
        App.db.dao.addPhoto(photo)
    }
}
