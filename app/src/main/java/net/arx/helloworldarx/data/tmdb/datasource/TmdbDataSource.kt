package net.arx.helloworldarx.data.tmdb.datasource

interface TmdbDataSource {

    suspend fun fetchMovieDetails(movie: String): TmdbDataModel

     suspend fun getTopMovies(apiKey: String, page: Int)
     suspend fun getPopularMovies(apiKey: String, page: Int)
     // Allh mia get gia thn epomenh kathgoria
}