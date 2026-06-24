package com.example.haya_sparkle.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WargaDao {

    @Insert
    suspend fun insert(warga: WargaEntity)

    @Query("SELECT * FROM warga")
    suspend fun getAll(): List<WargaEntity>

    @Delete
    suspend fun delete(data: WargaEntity)
}