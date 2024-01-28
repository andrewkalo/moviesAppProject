package net.arx.helloworldarx.data.tmdb.repository

import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.mapper.TmdbResponseMapper
import net.arx.helloworldarx.domain.tmdb.repository.TmdbListMovieResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieCreditsResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMoviesByCategoryResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
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

    override suspend fun fetchTopMovies(page: Int) : TmdbListMovieResult {
        TODO("Not yet implemented")
    }

    override suspend fun fetchMoviesByCategory(categoryId: Int): TmdbMoviesByCategoryResult {
        TODO("Not yet implemented")
    }

}