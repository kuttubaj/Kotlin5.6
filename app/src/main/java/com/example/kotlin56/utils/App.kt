package com.example.kotlin56.utils

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import com.example.kotlin56.data.local.room.entites.PhotoDatabase

private const val PHOTO_DATABASE = "my_database"

class App : Application() {
    companion object {
        lateinit var db: PhotoDatabase

            private set
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            PhotoDatabase::class.java,
            PHOTO_DATABASE
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}