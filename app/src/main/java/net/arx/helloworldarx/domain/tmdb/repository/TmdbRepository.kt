package net.arx.helloworldarx.domain.tmdb.repository


interface TmdbRepository {
    suspend fun fetchMovie(movieId: Int): TmdbMovieResult
    suspend fun fetchMovieCredits(movieId: Int): TmdbMovieCreditsResult

    suspend fun fetchMoviesByCategory(categoryId: Int): TmdbMoviesByCategoryResult
}