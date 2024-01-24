package net.arx.helloworldarx.framework.tmdb.api


import net.arx.helloworldarx.data.tmdb.datasource.MovieResponse
import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataModel
import retrofit2.Response
import retrofit2.http.Path
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TmdbApi {


    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMjlhOGJhZDA0ODNhOWVmZGYxZDc0ZDZlNGE0NDVhYSIsInN1YiI6IjY1OWQxOTZjN2ZjYWIzMDI1ZDQwODVlZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.n4Z2osV0_k3yHJr3ojA38m4kKV3nWzYVCBk-sa8ergc")
    @GET("/3/movie/{movieId}")
    suspend fun fetchMovieDetails(@Path("movieId") movie: String): TmdbDataModel

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMjlhOGJhZDA0ODNhOWVmZGYxZDc0ZDZlNGE0NDVhYSIsInN1YiI6IjY1OWQxOTZjN2ZjYWIzMDI1ZDQwODVlZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.n4Z2osV0_k3yHJr3ojA38m4kKV3nWzYVCBk-sa8ergc")
    @GET("/3/movie/top_rated")
    suspend fun getTopMovies(@Query("api_key") apiKey: String, @Query("page") page: Int): Response<MovieResponse>

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMjlhOGJhZDA0ODNhOWVmZGYxZDc0ZDZlNGE0NDVhYSIsInN1YiI6IjY1OWQxOTZjN2ZjYWIzMDI1ZDQwODVlZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.n4Z2osV0_k3yHJr3ojA38m4kKV3nWzYVCBk-sa8ergc")
    @GET("/3/movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String, @Query("page") page: Int): Response<MovieResponse>

}