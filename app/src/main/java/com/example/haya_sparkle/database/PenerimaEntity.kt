package com.example.haya_sparkle.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "penerima")
data class PenerimaEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nama: String,
    val bantuan: String,
    val keterangan: String
)
