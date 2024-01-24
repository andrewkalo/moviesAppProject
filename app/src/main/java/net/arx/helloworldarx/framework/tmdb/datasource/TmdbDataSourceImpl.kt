package net.arx.helloworldarx.framework.tmdb.datasource

import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataModel
import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.framework.tmdb.api.TmdbApi
import javax.inject.Inject


class TmdbDataSourceImpl @Inject constructor(
    private val tmdbApi: TmdbApi
) : TmdbDataSource {

    override suspend fun fetchMovieDetails(movie: String): TmdbDataModel {
        return tmdbApi.fetchMovieDetails(movie)
    }

    override suspend fun getTopMovies(apiKey: String, page: Int) {
        tmdbApi.getTopMovies(apiKey, page)
    }

    override suspend fun getPopularMovies(apiKey: String, page: Int) {
        tmdbApi.getPopularMovies(apiKey, page)
    }
    

}