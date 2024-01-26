package net.arx.helloworldarx.data.tmdb.datasource

import net.arx.helloworldarx.data.tmdb.local.LocalMovie

interface TmdbDataSource {
    suspend fun fetchMovie(movieId: Int): LocalMovie
}