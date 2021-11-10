package com.fearefull.moviefetcher.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by Aref Hosseini on ۱۰/۱۱/۲۰۲۱.
 */

@Parcelize
data class Movie(
    @SerializedName("Actors")
    val actors: String = "",

    @SerializedName("Awards")
    val awards: String = "",

    @SerializedName("BoxOffice")
    val boxOffice: String = "",

    @SerializedName("Country")
    val country: String = "",

    @SerializedName("DVD")
    val dvd: String = "",

    @SerializedName("Director")
    val director: String = "",

    @SerializedName("Genre")
    val genre: String = "",

    @SerializedName("imdbID")
    val imdbID: String = "",

    @SerializedName("imdbRating")
    val imdbRating: String = "",

    @SerializedName("imdbVotes")
    val imdbVotes: String = "",

    @SerializedName("Language")
    val language: String = "",

    @SerializedName("Metascore")
    val metascore: String = "",

    @SerializedName("Plot")
    val plot: String = "",

    @SerializedName("Poster")
    val poster: String = "",

    @SerializedName("Production")
    val production: String = "",

    @SerializedName("Rated")
    val rated: String = "",

    @SerializedName("Released")
    val released: String = "",

    @SerializedName("Response")
    val response: String = "",

    @SerializedName("Runtime")
    val runtime: String = "",

    @SerializedName("Title")
    val title: String = "",

    @SerializedName("Type")
    val type: String = "",

    @SerializedName("Website")
    val website: String = "",

    @SerializedName("Writer")
    val writer: String = "",

    @SerializedName("Year")
    val year: String = "",

    @SerializedName("Ratings")
    val ratings: List<Rating> = listOf()
) : Parcelable

@Parcelize
data class Rating(
    @SerializedName("Source")
    val source: String = "",

    @SerializedName("Value")
    val value: String = "",
) : Parcelable

@Entity(tableName = "favoriteMovies")
data class FavoriteMovieEntity(
    @PrimaryKey
    val imdbID: String,

    @ColumnInfo(name = "col_title")
    val title: String,

    @ColumnInfo(name = "col_poster")
    val poster: String,

    @ColumnInfo(name = "col_year")
    val year: Int,

    @ColumnInfo(name = "col_rating")
    val imdbRating: Double,
)

fun Movie.asFavoriteMovieEntity(): FavoriteMovieEntity =
    FavoriteMovieEntity(this.imdbID, this.title, this.poster, this.year.toInt(), this.imdbRating.toDouble())

fun FavoriteMovieEntity.asMovie(): Movie =
    Movie(imdbID = this.imdbID, title = this.title, poster = this.poster, year = this.year.toString(), imdbRating = this.imdbRating.toString())

fun List<FavoriteMovieEntity>.asMovieList(): List<Movie> = this.map {
    it.asMovie()
}
