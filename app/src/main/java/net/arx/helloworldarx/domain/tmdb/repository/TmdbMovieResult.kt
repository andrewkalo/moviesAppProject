package net.arx.helloworldarx.domain.tmdb.repository

import net.arx.helloworldarx.data.tmdb.local.LocalMovie

sealed class TmdbMovieResult {
    class SuccessMovieResult(val movieDetails: LocalMovie) : TmdbMovieResult()

    class NetworkWaringResult(val movieDetails: LocalMovie): TmdbMovieResult()

    object ApiError: TmdbMovieResult()

    object NetworkError: TmdbMovieResult()

    object UnknownError: TmdbMovieResult()

}
