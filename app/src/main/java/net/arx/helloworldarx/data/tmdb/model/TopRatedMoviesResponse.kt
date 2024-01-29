package net.arx.helloworldarx.data.tmdb.model



data class TopRatedMoviesResponse(
    val page: Int? = null,
    val numberOfPages: Int? = null,
    val result: List<TopRatedMovieItem>? = null,
    val numberOfResults: Int? = null
)