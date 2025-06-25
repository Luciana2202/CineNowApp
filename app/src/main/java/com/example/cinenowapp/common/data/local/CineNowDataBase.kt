package com.example.cinenowapp.common.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database([MovieEntity::class], version = 1)
abstract class CineNowDataBase : RoomDatabase() {
    abstract fun getMovieDao() : MovieDao
}