package net.arx.helloworldarx.domain.tmdb.repository

import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataModel

interface TmdbRepository {

    suspend fun fetchMovie(movie: String): TmdbDataModel

}