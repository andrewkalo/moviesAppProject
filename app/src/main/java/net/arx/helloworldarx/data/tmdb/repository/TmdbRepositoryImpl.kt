package net.arx.helloworldarx.data.tmdb.repository

import kotlinx.coroutines.flow.Flow
import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.mapper.TmdbResponseMapper
import net.arx.helloworldarx.data.tmdb.model.TopRatedMoviesResponse
import net.arx.helloworldarx.domain.tmdb.repository.TmdbListMovieResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieCreditsResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMoviesByCategoryResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import net.arx.helloworldarx.domain.tmdb.repository.TmdbTopRatedMoviesResult
import javax.inject.Inject

class TmdbRepositoryImpl @Inject constructor(
    private val dataSource: TmdbDataSource
) : TmdbRepository {
    override suspend fun fetchMovie(movieId: Int): TmdbMovieResult {
        val mapper = TmdbResponseMapper()
        return mapper(dataSource.fetchMovie(movieId))
    }

    override suspend fun fetchMovieCredits(movieId: Int): TmdbMovieCreditsResult {
        val mapper = TmdbResponseMapper()
        return mapper(dataSource.fetchMovieCredits(movieId))
    }

    override suspend fun getTopRatedMovies(lang: String, page: Int): Flow<TmdbTopRatedMoviesResult<TopRatedMoviesResponse>> {
        return dataSource.getTopRatedMovies(lang,page)
    }

    override suspend fun fetchMoviesByCategory(categoryId: Int): TmdbMoviesByCategoryResult {
        TODO("Not yet implemented")
    }

}