package net.arx.helloworldarx.data.tmdb.local

import androidx.room.Entity
import androidx.room.PrimaryKey

class LocalMoviesByCategory {
    @Entity(tableName = "movies")
    data class LocalMovie(
        @PrimaryKey val id: Int,
        val title: String,
        val voteAverage: Double,
        val popularity: Double,
        val poster_path: String?,
        val backdrop_path: String?,
    )
}