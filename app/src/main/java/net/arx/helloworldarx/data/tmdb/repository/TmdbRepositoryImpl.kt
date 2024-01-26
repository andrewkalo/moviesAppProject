package net.arx.helloworldarx.data.tmdb.repository

import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.data.tmdb.mapper.TmdbResponseMapper
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import javax.inject.Inject

class TmdbRepositoryImpl @Inject constructor(
    private val dataSource: TmdbDataSource
) : TmdbRepository {
    override suspend fun fetchMovie(movie: Int): TmdbMovieResult {
        val mapper = TmdbResponseMapper()
        return mapper(dataSource.fetchMovie(movie))
    }
}