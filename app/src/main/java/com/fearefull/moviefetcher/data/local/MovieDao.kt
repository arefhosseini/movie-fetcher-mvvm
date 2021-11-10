package com.fearefull.moviefetcher.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fearefull.moviefetcher.data.model.FavoriteMovieEntity

/**
 * Created by Aref Hosseini on ۱۰/۱۱/۲۰۲۱.
 */

@Dao
interface MovieDao {
    @Query("SELECT * FROM favoriteMovies")
    suspend fun getAllFavoriteMovies(): List<FavoriteMovieEntity>

    @Query("SELECT * FROM favoriteMovies")
    suspend fun getAllFavoriteMoviesWithChanges(): LiveData<List<FavoriteMovieEntity>>

    @Query("SELECT * FROM favoriteMovies WHERE col_title LIKE '%' || :title || '%'") // This Like operator is needed due that the API returns blank spaces in the name
    suspend fun getFavoriteMovies(title: String): List<FavoriteMovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavoriteMovie(favoriteMovieEntity: FavoriteMovieEntity)

    @Delete
    suspend fun deleteFavoriteMovie(favoriteMovieEntity: FavoriteMovieEntity)

    @Query("SELECT * FROM favoriteMovies WHERE imdbID = :imdbID")
    suspend fun getFavoriteMovieByImdbID(imdbID: String): FavoriteMovieEntity?
}