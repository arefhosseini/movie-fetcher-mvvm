package com.fearefull.moviefetcher.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fearefull.moviefetcher.data.model.FavoriteMovieEntity

/**
 * Created by Aref Hosseini on ۱۰/۱۱/۲۰۲۱.
 */

@Database(entities = [FavoriteMovieEntity::class],version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}