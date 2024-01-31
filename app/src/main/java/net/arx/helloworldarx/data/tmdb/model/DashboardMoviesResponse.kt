package net.arx.helloworldarx.data.tmdb.model



data class DashboardMoviesResponse(
    val page: Int?,
    val results: List<DashboardMovieItem>?
)