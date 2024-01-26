package net.arx.helloworldarx.data.tmdb.mapper

import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieResult
import javax.inject.Inject

class TmdbResponseMapper @Inject constructor(){

    operator fun invoke(localMovie: LocalMovie): TmdbMovieResult {

        return when (localMovie.success) {
            true -> {
                TmdbMovieResult.SuccessMovieResult(localMovie)
            }
            false -> TmdbMovieResult.ApiError
        }
    }
}