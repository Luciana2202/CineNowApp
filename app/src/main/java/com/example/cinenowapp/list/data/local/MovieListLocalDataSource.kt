package com.example.cinenowapp.list.data.local

import com.example.cinenowapp.common.data.local.MovieCategory
import com.example.cinenowapp.common.data.local.MovieDao
import com.example.cinenowapp.common.data.local.MovieEntity
import com.example.cinenowapp.common.data.model.Movie
import javax.inject.Inject

class MovieListLocalDataSource @Inject constructor(
    private val dao: MovieDao,
) : LocalDataSource {
    override suspend fun getNowPlayingMovies(): List<Movie> {
        return getMovieByCategory(MovieCategory.NowPlaying)
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        return getMovieByCategory(MovieCategory.TopRated)
    }

    override suspend fun getPopularMovies(): List<Movie> {
        return getMovieByCategory(MovieCategory.Popular)
    }

    override suspend fun getUpcomingMovies(): List<Movie> {
        return getMovieByCategory(MovieCategory.Upcoming)
    }

    override suspend fun updateLocalItems(movies: List<Movie>) {
        val entities = movies.map {
            MovieEntity(
                id = it.id,
                title = it.title,
                overview = it.overview,
                category = it.category,
                image = it.image
            )
        }
        dao.insertAll(entities)
    }
    private suspend fun getMovieByCategory(movieCategory: MovieCategory): List<Movie> {
        val entities = dao.getMoviesByCategory(movieCategory.name)
        return entities.map {
            Movie(
                id = it.id,
                title = it.title,
                overview = it.overview,
                image = it.image,
                category = it.category
            )
        }
    }
}