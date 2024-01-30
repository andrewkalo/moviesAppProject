package net.arx.helloworldarx.ui.Dashboard

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import net.arx.helloworldarx.ui.base.BaseViewModel
import net.arx.helloworldarx.usecase.DashboardUseCases.FetchMovieByCategoryUseCase
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.arx.helloworldarx.data.tmdb.model.TopRatedMovieItem
import net.arx.helloworldarx.domain.tmdb.repository.TmdbTopRatedMoviesResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber

@HiltViewModel
class DashboardViewModel @Inject constructor(
    val fetchMovieByCategoryUseCase: FetchMovieByCategoryUseCase
) : BaseViewModel() {

    private val _topRatedMoviesStateFlow = MutableStateFlow<List<TopRatedMovieItem>>(emptyList())
    val topRatedMoviesStateFlow: StateFlow<List<TopRatedMovieItem>> = _topRatedMoviesStateFlow



    init {
        viewModelScope.launch(Dispatchers.IO) {
            fetchMovieByCategoryUseCase.invoke("en-US", 2).collect {
                when (it) {
                    is TmdbTopRatedMoviesResult.Data -> {
                        val resultList = it.value.result.orEmpty()
                        _topRatedMoviesStateFlow.value = resultList
                        Timber.tag("API").d("%s movies", "Received " + resultList.size)
                        delay(1000)
                        //loading to false
                    }
                    is TmdbTopRatedMoviesResult.Error -> {
                        // handle error if needed
                    }
                    is TmdbTopRatedMoviesResult.Loading -> {
                        // loading to true
                    }
                }
            }
        }
    }
}

