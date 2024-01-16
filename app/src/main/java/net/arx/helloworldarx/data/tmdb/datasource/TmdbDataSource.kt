package net.arx.helloworldarx.data.tmdb.datasource

interface TmdbDataSource {
     suspend fun getTopMovies()
     suspend fun getPopularMovies()
     // Allh mia get gia thn epomenh kathgoria
}