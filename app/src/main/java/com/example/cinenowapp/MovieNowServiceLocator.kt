package com.example.cinenowapp

import android.app.Application
import androidx.room.Room
import com.example.cinenowapp.common.data.local.CineNowDataBase
import com.example.cinenowapp.common.data.remote.RetrofitClient
import com.example.cinenowapp.list.data.MovieListRepository
import com.example.cinenowapp.list.data.local.LocalDataSource
import com.example.cinenowapp.list.data.local.MovieListLocalDataSource
import com.example.cinenowapp.list.data.remote.ListService
import com.example.cinenowapp.list.data.remote.MovieListRemoteDataSource
import com.example.cinenowapp.list.data.remote.RemoteDataSource

object MovieNowServiceLocator {

    fun getRepository(application: Application): MovieListRepository {
        val db by lazy {
            Room.databaseBuilder(
                application.applicationContext,
                CineNowDataBase::class.java, "database-cine-now"
            ).build()
        }

        val listService = RetrofitClient.retrofitInstance.create(ListService::class.java)

        val localDataSource: LocalDataSource = MovieListLocalDataSource(db.getMovieDao())

        val remoteDataSource: RemoteDataSource = MovieListRemoteDataSource(listService)

        return MovieListRepository(
            local = localDataSource,
            remote = remoteDataSource
        )

    }
}