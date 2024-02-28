package com.example.kotlin56.data.local.room.entites

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlin56.data.local.room.model.Photo

@Database(entities = [Photo::class], version = 1, exportSchema = false)

abstract class PhotoDatabase:RoomDatabase() {
    abstract val dao:PhotoDao
}