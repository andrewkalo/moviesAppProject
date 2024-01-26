package net.arx.helloworldarx.data.tmdb.datasource

import net.arx.helloworldarx.data.tmdb.local.LocalMovie

interface TmdbDataSource {
    suspend fun fetchMovie(movieId: Int): LocalMovie
     suspend fun getTopMovies(apiKey: String, page: Int)
     suspend fun getPopularMovies(apiKey: String, page: Int)
     // Allh mia get gia thn epomenh kathgoria
}