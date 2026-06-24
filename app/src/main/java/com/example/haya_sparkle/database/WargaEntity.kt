package com.example.haya_sparkle.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "warga")
data class WargaEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nama: String,
    val nik: String,
    val alamat: String,
    val pekerjaan: String,
    val kontak: String
)