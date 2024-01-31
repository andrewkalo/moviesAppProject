package net.arx.helloworldarx.ui.Dashboard

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.arx.helloworldarx.data.tmdb.model.DashboardMovieItem
import net.arx.helloworldarx.domain.tmdb.repository.DashboardMoviesResult
import net.arx.helloworldarx.domain.tmdb.repository.UpcomingMoviesResult
import net.arx.helloworldarx.ui.base.BaseViewModel
import net.arx.helloworldarx.usecase.DashboardUseCases.FetchPopularMoviesUseCase
import net.arx.helloworldarx.usecase.DashboardUseCases.FetchTopRatedMoviesUseCase
import net.arx.helloworldarx.usecase.DashboardUseCases.fetchUpcomingMoviesUseCase
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    val fetchTopRatedMoviesUseCase: FetchTopRatedMoviesUseCase,
    val fetchPopularMoviesUseCase: FetchPopularMoviesUseCase,
    val fetchUpcomingMoviesUseCase: fetchUpcomingMoviesUseCase
) : BaseViewModel() {

    // StateFlow for representing UI state
    private var _topRatedMovieList = mutableStateListOf<DashboardMovieItem>()
    val topRatedMovieList: List<DashboardMovieItem> = _topRatedMovieList

    private var _popularMovieList = mutableStateListOf<DashboardMovieItem>()
    val popularMovieList: List<DashboardMovieItem> = _popularMovieList

    private var _upcomingMovieList = mutableStateListOf<DashboardMovieItem>()
    val upcomingMovieList : List<DashboardMovieItem> = _upcomingMovieList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            fetchTopRatedMoviesUseCase("en-US", 1).collect {
                Timber.tag("DashboardViewModel").w("Result: " + it)
                when (it) {
                    is DashboardMoviesResult.Data -> {
                        _topRatedMovieList.clear()
                        it.value?.results?.let { results ->
                            _topRatedMovieList.addAll(results)
                        }

                    }

                    is DashboardMoviesResult.Error -> {
                        // Handle error if needed
                    }

                    is DashboardMoviesResult.Loading -> {
                        // loading to true
                    }
                }
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            fetchPopularMoviesUseCase("en-US", 1).collect {
                Timber.tag("DashboardViewModel2").w("Result: " + it)
                when (it) {
                    is DashboardMoviesResult.Data -> {
                        _popularMovieList.clear()
                        it.value?.results?.let { results ->
                            _popularMovieList.addAll(results)
                        }

                    }

                    is DashboardMoviesResult.Error -> {
                        // Handle error if needed
                    }

                    is DashboardMoviesResult.Loading -> {
                        // loading to true
                    }
                }
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            fetchUpcomingMoviesUseCase("en-US",1).collect {
                Timber.tag("DashboardViewModel2").w("Result: " + it)
                when (it) {
                    is UpcomingMoviesResult.Data -> {
                        _upcomingMovieList.clear()
                        it.value?.results?.let { results ->
                            _upcomingMovieList.addAll(results)
                        }

                    }

                    is UpcomingMoviesResult.Error -> {
                        // Handle error if needed
                    }

                    is UpcomingMoviesResult.Loading -> {
                        // loading to true
                    }
                }
            }
        }
    }
}



