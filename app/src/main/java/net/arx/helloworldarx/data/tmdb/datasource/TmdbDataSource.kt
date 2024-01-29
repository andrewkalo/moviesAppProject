package net.arx.helloworldarx.data.tmdb.datasource

import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits
import net.arx.helloworldarx.data.tmdb.local.LocalMoviesByCategory

interface TmdbDataSource {
    suspend fun fetchMovie(movieId: Int): LocalMovie

    suspend fun fetchMovieCredits(movieId: Int): List<LocalMovieCredits>


    suspend fun fetchMoviesByCategory(categoryId: Int): List<LocalMoviesByCategory>
    suspend fun fetchTopMovies(): List<LocalMovie>
    suspend fun fetchPopularMovies(): List <LocalMovie>
// Allh mia get gia thn epomenh kathgoria
}