package com.example.cinenowapp.list.data.remote

import com.example.cinenowapp.common.data.model.Movie

interface RemoteDataSource {

    suspend fun getNowPlayingMovies(): Result<List<Movie>?>

    suspend fun getTopRatedMovies(): Result<List<Movie>?>

    suspend fun getPopularMovies(): Result<List<Movie>?>

    suspend fun getUpcomingMovies(): Result<List<Movie>?>

}