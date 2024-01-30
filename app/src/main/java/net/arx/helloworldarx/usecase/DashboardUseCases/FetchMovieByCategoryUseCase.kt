package net.arx.helloworldarx.usecase.DashboardUseCases

import android.util.Log
import kotlinx.coroutines.flow.Flow
import net.arx.helloworldarx.data.tmdb.model.TopRatedMoviesResponse
import net.arx.helloworldarx.domain.tmdb.repository.TmdbListMovieResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import net.arx.helloworldarx.domain.tmdb.repository.TmdbTopRatedMoviesResult
import javax.inject.Inject

class FetchMovieByCategoryUseCase @Inject constructor(
    val repository: TmdbRepository
) {
    suspend operator fun invoke(lang: String, page: Int): Flow<TmdbTopRatedMoviesResult<TopRatedMoviesResponse>> {
        return repository.getTopRatedMovies(lang, page)

    }
}