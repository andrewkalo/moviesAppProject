package net.arx.helloworldarx.data.tmdb.model



data class TopRatedMoviesResponse(
    val page: Int? = null,
    val results: List<TopRatedMovieItem> ,
)