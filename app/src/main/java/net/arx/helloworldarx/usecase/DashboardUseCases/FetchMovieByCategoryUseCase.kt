package net.arx.helloworldarx.usecase.DashboardUseCases

import android.util.Log
import kotlinx.coroutines.flow.Flow
import net.arx.helloworldarx.data.tmdb.model.TopRatedMoviesResponse
import net.arx.helloworldarx.domain.tmdb.repository.TmdbListMovieResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import net.arx.helloworldarx.domain.tmdb.repository.TmdbTopRatedMoviesResult
import timber.log.Timber
import javax.inject.Inject

class FetchMovieByCategoryUseCase @Inject constructor(
    val repository: TmdbRepository
) {
    suspend operator fun invoke(lang: String, page: Int): Flow<TmdbTopRatedMoviesResult<TopRatedMoviesResponse>> {
        Timber.tag("REPOSITORY").w("MOVIES " + repository.getTopRatedMovies(lang, page))
        return repository.getTopRatedMovies(lang, page)

    }
}