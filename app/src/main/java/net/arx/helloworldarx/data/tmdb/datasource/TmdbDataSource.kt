package net.arx.helloworldarx.data.tmdb.datasource

interface TmdbDataSource {

    suspend fun fetchMovieDetails(movie: String): TmdbDataModel

}