package com.fearefull.moviefetcher.data.remote

import com.fearefull.moviefetcher.data.model.Movie
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Aref Hosseini on ۱۰/۱۱/۲۰۲۱.
 */

interface WebService {
    @GET("URL")
    suspend fun getMovieByImdbID(@Query(value = "i") imdbID: String,
                                 @Query(value = "apikey") apiKey: String): Movie
}