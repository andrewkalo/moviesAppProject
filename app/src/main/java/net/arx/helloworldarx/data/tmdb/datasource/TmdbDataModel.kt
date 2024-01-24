package net.arx.helloworldarx.data.tmdb.datasource

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Genre(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
data class TmdbDataModel(
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "genre_ids")
    val genreIds: List<Int>?,
    @Json(name = "genres")
    val genres: List<Genre>?,
    @Json(name = "media_type")
    val mediaType: String?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "imdb_id")
    val imdbId: String?,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "popularity")
    val popularity: Double,
    @Json(name = "release_date") // TODO alternate = ["first_air_date"]
    val releaseDate: String,
    @Json(name = "runtime")
    val runtime: Int?,
    @Json(name = "title") // TODO alternate = ["name"]
    val title: String,
    @Json(name = "video")
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Int
)

@JsonClass(generateAdapter = true)
data class Movie(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "poster_path")
    val posterPath: String?
)

data class MovieResponse(
    val results: List<Movie>
)