package net.arx.helloworldarx.domain.tmdb.repository

import kotlinx.coroutines.flow.Flow
import net.arx.helloworldarx.data.tmdb.model.TopRatedMoviesResponse

interface TmdbRepository {
    suspend fun fetchMovie(movieId: Int): TmdbMovieResult
    suspend fun fetchMovieCredits(movieId: Int): TmdbMovieCreditsResult

    suspend fun fetchMoviesByCategory(categoryId: Int): TmdbMoviesByCategoryResult

    suspend fun  getTopRatedMovies(lang: String, page: Int): Flow<TmdbTopRatedMoviesResult<TopRatedMoviesResponse>>
}