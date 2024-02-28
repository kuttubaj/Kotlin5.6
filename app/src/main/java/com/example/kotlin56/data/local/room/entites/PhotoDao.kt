package com.example.kotlin56.data.local.room.entites

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlin56.data.local.room.model.Photo

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photo_table")
    fun getAllPhoto(): List<Photo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPhoto(photo: Photo)
}
