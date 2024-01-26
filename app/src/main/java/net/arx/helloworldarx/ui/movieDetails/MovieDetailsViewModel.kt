package net.arx.helloworldarx.ui.movieDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieResult
import net.arx.helloworldarx.ui.base.BaseViewModel
import net.arx.helloworldarx.usecase.movieDetails.GetMovieDataUseCase
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDataUseCase: GetMovieDataUseCase //Automatically injected when calling "by viewModels()" in fragment
) : BaseViewModel() {

    private var _movieData = mutableStateOf<LocalMovie?>(null)
    val movieData: State<LocalMovie?> = _movieData
    fun getMovie(movieId: Int){
        viewModelScope.launch{
            val movieData = getMovieDataUseCase(movieId)
            movieData.apply {
                when(this){
                    is TmdbMovieResult.SuccessMovieResult -> {
                        _movieData.value = this.movieDetails
                    }
                    is TmdbMovieResult.NetworkWaringResult ->{
                        _movieData.value = this.movieDetails
                    }
                    is TmdbMovieResult.NetworkError -> {
                        _movieData.value = null
                    }
                    is TmdbMovieResult.ApiError ->{
                        _movieData.value = null
                    }
                    is TmdbMovieResult.UnknownError ->{
                        _movieData.value = null
                    }
                }
            }
        }
    }

}