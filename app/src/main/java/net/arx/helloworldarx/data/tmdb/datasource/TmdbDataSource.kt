package net.arx.helloworldarx.data.tmdb.datasource

import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits

interface TmdbDataSource {
    suspend fun fetchMovie(movieId: Int): LocalMovie

    suspend fun fetchMovieCredits(movieId: Int): List<LocalMovieCredits>

     suspend fun getTopMovies(): List <LocalMovie>?
     suspend fun getPopularMovies(): List <LocalMovie>?
     // Allh mia get gia thn epomenh kathgoria
}