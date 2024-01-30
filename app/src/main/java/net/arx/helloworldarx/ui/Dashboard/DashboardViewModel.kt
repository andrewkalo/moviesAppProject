package net.arx.helloworldarx.ui.Dashboard

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
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

@HiltViewModel
class DashboardViewModel @Inject constructor(
    val fetchMovieByCategoryUseCase: FetchMovieByCategoryUseCase
) : BaseViewModel() {

    // StateFlow for representing UI state
    private var _topRatedMovieList = mutableStateListOf<TopRatedMovieItem>()
    val topRatedMovieList: List<TopRatedMovieItem> = _topRatedMovieList


    init {
        // ...

        @HiltViewModel
        class DashboardViewModel @Inject constructor(
            val fetchMovieByCategoryUseCase: FetchMovieByCategoryUseCase
        ) : BaseViewModel() {

            private var _topRatedMovieList = mutableStateListOf<TopRatedMovieItem>()
            val topRatedMovieList: List<TopRatedMovieItem> = _topRatedMovieList

            init {
                viewModelScope.launch(Dispatchers.IO) {
                    fetchMovieByCategoryUseCase.invoke("en-US", 2).collect {
                        when (it) {
                            is TmdbTopRatedMoviesResult.Data -> {
                                _topRatedMovieList.clear()
                                it.value?.results?.let { results ->
                                    _topRatedMovieList.addAll(results)
                                }

                            }

                            is TmdbTopRatedMoviesResult.Error -> {
                                // Handle error if needed
                            }

                            is TmdbTopRatedMoviesResult.Loading -> {
                                // loading to true
                            }
                        }
                    }
                }
            }
        }
    }
    }



