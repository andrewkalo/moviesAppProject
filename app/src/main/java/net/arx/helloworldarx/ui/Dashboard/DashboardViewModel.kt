package net.arx.helloworldarx.ui.Dashboard

import dagger.hilt.android.lifecycle.HiltViewModel
import net.arx.helloworldarx.ui.base.BaseViewModel
import net.arx.helloworldarx.usecase.DashboardUseCases.FetchMovieByCategoryUseCase
import javax.inject.Inject
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.arx.helloworldarx.data.tmdb.model.TopRatedMovieItem
import net.arx.helloworldarx.domain.tmdb.repository.TmdbTopRatedMoviesResult
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf

@HiltViewModel
class DashboardViewModel @Inject constructor(
    val fetchMovieByCategoryUseCase: FetchMovieByCategoryUseCase
) : BaseViewModel() {

    private var _topRatedMovieList = mutableStateListOf<TopRatedMovieItem>()
    val topRatedMovieList: List<TopRatedMovieItem> = _topRatedMovieList

    //private val _apiError = mutableStateOf(false)
    //val apiError: State<Boolean> = _apiError

   // private var _isLoading = mutableStateMapOf<Int, Boolean>()
    //val isLoading: Map<Int, Boolean> = _isLoading

    init {
        viewModelScope.launch{
            fetchMovieByCategoryUseCase.invoke("en-US",1).collect{
                when (it) {

                    is TmdbTopRatedMoviesResult.Data -> {

                        _topRatedMovieList.clear()
                        it.value.result?.forEach { result ->
                            _topRatedMovieList.add(result)
                        }
                        delay(1000)
                       // _isLoading[3] = false


                    }
                    is TmdbTopRatedMoviesResult.Error -> {
                       // _apiError.value = true
                        //_isLoading[3] = false
                    }

                    is TmdbTopRatedMoviesResult.Loading -> {
                       // _isLoading[3] = true
                    }
                }
            }
        }
    }

}
