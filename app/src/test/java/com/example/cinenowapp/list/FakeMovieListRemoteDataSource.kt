package com.example.cinenowapp.list

import com.example.cinenowapp.common.data.model.Movie
import com.example.cinenowapp.list.data.remote.RemoteDataSource
import java.net.UnknownHostException

class FakeMovieListRemoteDataSource : RemoteDataSource {

    var nowPlaying = emptyList<Movie>()
    var topRated = emptyList<Movie>()
    var popular = emptyList<Movie>()
    var upcoming = emptyList<Movie>()
    var shouldReturnError = false

    override suspend fun getNowPlayingMovies(): Result<List<Movie>?> {
        return if (shouldReturnError) {
            Result.failure(UnknownHostException("No internet"))
        } else {
            return Result.success(nowPlaying)
        }
    }

    override suspend fun getTopRatedMovies(): Result<List<Movie>?> {
        return if (shouldReturnError) {
            Result.failure(UnknownHostException("No internet"))
        } else {
            return Result.success(topRated)
        }
    }

    override suspend fun getPopularMovies(): Result<List<Movie>?> {
        return if (shouldReturnError) {
            Result.failure(UnknownHostException("No internet"))
        } else {
            return Result.success(popular)
        }
    }

    override suspend fun getUpcomingMovies(): Result<List<Movie>?> {
        return if (shouldReturnError) {
            Result.failure(UnknownHostException("No internet"))
        } else {
            return Result.success(upcoming)
        }
    }

}