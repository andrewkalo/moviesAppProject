package net.arx.helloworldarx.domain.tmdb.repository

import net.arx.helloworldarx.data.tmdb.local.LocalMovie
sealed class TmdbMoviesByCategoryResult {


    object ApiError: TmdbMoviesByCategoryResult()

    object NetworkError: TmdbMoviesByCategoryResult()

    object UnknownError: TmdbMoviesByCategoryResult()
    object ErrorResult: TmdbMoviesByCategoryResult()
}