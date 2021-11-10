package com.fearefull.moviefetcher.data.remote

import com.fearefull.moviefetcher.core.Resource
import com.fearefull.moviefetcher.data.model.Movie
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

/**
 * Created by Aref Hosseini on ۱۰/۱۱/۲۰۲۱.
 */

@ExperimentalCoroutinesApi
class NetworkDataSource @Inject constructor(
    private val webService: WebService
) {
    suspend fun getMovieByImdbID(imdbID: String): Flow<Resource<Movie>> =
        callbackFlow {
            trySend(
                Resource.Success(
                    webService.getMovieByImdbID(imdbID, "fd1254ed") //TODO: add apikey
                )
            )
            awaitClose { close() }
        }
}