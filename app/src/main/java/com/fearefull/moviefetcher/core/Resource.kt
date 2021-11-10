package com.fearefull.moviefetcher.core

/**
 * Created by Aref Hosseini on ۱۰/۱۱/۲۰۲۱.
 */

sealed class Resource<out T> {
    object Loading: Resource<Nothing>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Failure(val exception : Exception) : Resource<Nothing>()
}