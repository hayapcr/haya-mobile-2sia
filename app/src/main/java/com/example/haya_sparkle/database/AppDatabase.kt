package com.example.haya_sparkle.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        PenerimaEntity::class,
        WargaEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun penerimaDao(): PenerimaDao

    abstract fun wargaDao(): WargaDao
}