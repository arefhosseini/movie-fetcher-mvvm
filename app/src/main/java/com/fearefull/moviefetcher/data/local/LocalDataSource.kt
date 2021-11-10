package com.fearefull.moviefetcher.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.fearefull.moviefetcher.core.Resource
import com.fearefull.moviefetcher.data.model.Movie
import com.fearefull.moviefetcher.data.model.asFavoriteMovieEntity
import com.fearefull.moviefetcher.data.model.asMovieList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

/**
 * Created by Aref Hosseini on ۱۰/۱۱/۲۰۲۱.
 */

@ExperimentalCoroutinesApi
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {
    suspend fun saveFavoriteMovie(movie: Movie) {
        return movieDao.saveFavoriteMovie(movie.asFavoriteMovieEntity())
    }

    suspend fun getFavoriteMovies(): LiveData<List<Movie>> {
        return movieDao.getAllFavoriteMoviesWithChanges().map { it.asMovieList() }
    }

    suspend fun deleteMovie(movie: Movie) {
        return movieDao.deleteFavoriteMovie(movie.asFavoriteMovieEntity())
    }

    suspend fun saveMovie(movie: Movie) {
        return movieDao.saveFavoriteMovie(movie.asFavoriteMovieEntity())
    }

    suspend fun getCachedMovies(title: String): Resource<List<Movie>> {
        return Resource.Success(movieDao.getFavoriteMovies(title).asMovieList())
    }

    suspend fun isMovieFavorite(movie: Movie): Boolean {
        return movieDao.getFavoriteMovieByImdbID(movie.imdbID) != null
    }
}