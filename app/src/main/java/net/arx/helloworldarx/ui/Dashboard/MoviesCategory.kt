package net.arx.helloworldarx.ui.Dashboard


sealed class MoviesCategory(val value: String){
    object TopTenMovies: MoviesCategory("Top 10 Movies")
    object PopularMovies: MoviesCategory("Popular Movies")

    object UpcomingMovies: MoviesCategory("Upcoming Movies")
}