package net.arx.helloworldarx.framework.tmdb.api

import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface TmdbApi {

    @GET("path/here")
    suspend fun getExampleChangeName(@Path("example") example: String): String

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMzQwYWY2YmZkNGE3OWUyZTIwMTgyMDkxNmU5MjU5NSIsInN1YiI6IjY1YTRmOTIzMWZiOTRmMDBjMDc0OThiMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.M_-vuPeuY5kac4ycWHx7N2f1A4jXZkQp0WBIOEsh_j0")
    @GET("/3/movie/{movieId}")
    suspend fun fetchMovieDetails(@Path("movieId") movie: String): TmdbDataModel
}