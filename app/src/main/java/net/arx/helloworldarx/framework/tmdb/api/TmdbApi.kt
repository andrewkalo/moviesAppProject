package net.arx.helloworldarx.framework.tmdb.api


import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import net.arx.helloworldarx.BuildConfig
import net.arx.helloworldarx.domain.MoviesResponse
import net.arx.helloworldarx.domain.getAllMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TmdbApi {

    @Headers("Authorization: Bearer ${BuildConfig.API_KEY}")
    @GET("/3/movie/{movieId}")
    suspend fun fetchMovieDetails(@Path("movieId") movie: String): TmdbDataModel
  
    @GET("/3/movie/top_rated")
    @Headers("Authorization: Bearer ${BuildConfig.API_KEY}")
    suspend fun getTopMovies(): MoviesResponse

    @GET("/3/movie/popular")
    @Headers("Authorization: Bearer ${BuildConfig.API_KEY}")
    suspend fun getPopularMovies(): MoviesResponse

}