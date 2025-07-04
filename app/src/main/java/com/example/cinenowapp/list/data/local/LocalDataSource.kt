package com.example.cinenowapp.list.data.local

import com.example.cinenowapp.common.data.model.Movie

interface LocalDataSource {

    suspend fun getNowPlayingMovies(): List<Movie>

    suspend fun getTopRatedMovies(): List<Movie>

    suspend fun getPopularMovies(): List<Movie>

    suspend fun getUpcomingMovies(): List<Movie>

    suspend fun updateLocalItems(movies: List<Movie>)
}