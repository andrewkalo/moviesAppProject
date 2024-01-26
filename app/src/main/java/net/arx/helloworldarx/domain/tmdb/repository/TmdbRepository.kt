package net.arx.helloworldarx.domain.tmdb.repository


interface TmdbRepository {
    suspend fun fetchMovie(movie: Int): TmdbMovieResult

}