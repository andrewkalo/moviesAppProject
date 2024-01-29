package net.arx.helloworldarx.ui.Dashboard

import dagger.hilt.android.lifecycle.HiltViewModel
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.ui.base.BaseViewModel
import net.arx.helloworldarx.usecase.DashboardUseCases.FetchMovieByCategoryUseCase
import javax.inject.Inject
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.arx.helloworldarx.domain.tmdb.repository.TmdbListMovieResult
@HiltViewModel
class DashboardViewModel @Inject constructor(
    val fetchMovieByCategoryUseCase: FetchMovieByCategoryUseCase
) : BaseViewModel() {

    private var _listOfTopMovies = mutableStateListOf<LocalMovie?>()
    var listOfTopMovies: SnapshotStateList<LocalMovie?> = _listOfTopMovies

    fun fetchTopMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val listOfMoviesResult = fetchMovieByCategoryUseCase()

            when (listOfMoviesResult) {
                is TmdbListMovieResult.SuccessListMovieResult -> {
                    _listOfTopMovies.clear()
                    _listOfTopMovies.addAll(listOfMoviesResult.movieDetails)
                }
                is TmdbListMovieResult.NetworkWaringResult -> {
                    _listOfTopMovies.clear()
                    _listOfTopMovies.addAll(listOfMoviesResult.movieDetails)
                }
                is TmdbListMovieResult.ApiError,
                is TmdbListMovieResult.NetworkError,
                is TmdbListMovieResult.UnknownError -> {
                    _listOfTopMovies.clear()
                }
            }
        }
    }

}
