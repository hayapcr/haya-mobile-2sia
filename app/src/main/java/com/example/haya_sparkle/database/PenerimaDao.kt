package com.example.haya_sparkle.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PenerimaDao {

    @Insert
    suspend fun insert(data: PenerimaEntity)

    @Query("SELECT * FROM penerima")
    suspend fun getAll(): List<PenerimaEntity>

    @Delete
    suspend fun delete(data: PenerimaEntity)
}
