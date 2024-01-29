package net.arx.helloworldarx.usecase.DashboardUseCases

import net.arx.helloworldarx.domain.tmdb.repository.TmdbListMovieResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import javax.inject.Inject

class FetchMovieByCategoryUseCase @Inject constructor(
    val repository: TmdbRepository
) {
    suspend operator fun invoke(): TmdbListMovieResult {
        return try {
            repository.fetchTopMovies()
        } catch (e: Exception) {
            TmdbListMovieResult.ApiError
        }
    }
}