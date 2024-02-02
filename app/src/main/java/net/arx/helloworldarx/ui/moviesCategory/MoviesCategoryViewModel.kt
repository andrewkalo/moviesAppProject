package net.arx.helloworldarx.ui.moviesCategory


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.local.LocalMoviesByCategory
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMoviesByCategoryResult
import net.arx.helloworldarx.ui.base.BaseViewModel
import net.arx.helloworldarx.usecase.moviesCategory.GetLocalMoviesByCategoryUseCase
import javax.inject.Inject

@HiltViewModel
class MoviesCategoryViewModel @Inject constructor(
    private val getLocalMoviesByCategoryUseCase: GetLocalMoviesByCategoryUseCase
):BaseViewModel(){

    private var _moviesCategoryData = mutableStateListOf<LocalMoviesByCategory?>()
    val moviesCategoryData: List<LocalMoviesByCategory?> = _moviesCategoryData

    private var _isLoadingMoviesCategory = mutableStateOf(false)
    val isLoadingMoviesCategory = _isLoadingMoviesCategory

    private var _errorLoadingMoviesCategory = mutableStateOf(false)
    val errorLoadingMoviesCategory = _errorLoadingMoviesCategory

    private var _emptyLoadingMoviesCategory = mutableStateOf(false)
    val emptyLoadingMoviesCategory = _emptyLoadingMoviesCategory

    /*
    init{
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            getLocalMoviesByCategoryUseCase.collect {
                when (it) {
                    is TmdbMoviesByCategoryResult.Data -> {
                        _isLoadingMoviesCategory.value = false
                        _errorLoadingMoviesCategory.value = false
                        _emptyLoadingMoviesCategory.value = false
                        _moviesCategoryData.clear()
                        it.value?.results?.let { results ->
                            _moviesCategoryData.addAll(results)
                        }

                    }

                    is TmdbMoviesByCategoryResult.Error -> {
                        _isLoadingMoviesCategory.value = false
                        _errorLoadingMoviesCategory.value = true
                        _emptyLoadingMoviesCategory.value = false
                    }

                    is TmdbMoviesByCategoryResult.Loading -> {
                        _isLoadingMoviesCategory.value = true
                        _errorLoadingMoviesCategory.value = false
                        _emptyLoadingMoviesCategory.value = false
                    }

                    is TmdbMoviesByCategoryResult.Empty -> {
                        _isLoadingMoviesCategory.value = false
                        _errorLoadingMoviesCategory.value = false
                        _emptyLoadingMoviesCategory.value = true
                    }
                }
            }
        }
    }

     */






}