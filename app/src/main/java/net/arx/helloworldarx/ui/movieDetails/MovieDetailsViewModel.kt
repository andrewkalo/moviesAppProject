package net.arx.helloworldarx.ui.movieDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieCreditsResult
import net.arx.helloworldarx.domain.tmdb.repository.TmdbMovieResult
import net.arx.helloworldarx.ui.base.BaseViewModel
import net.arx.helloworldarx.usecase.movieDetails.GetMovieCreditsUseCase
import net.arx.helloworldarx.usecase.movieDetails.GetMovieDataUseCase
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDataUseCase: GetMovieDataUseCase,
    private val getMovieCreditsUseCase: GetMovieCreditsUseCase //Automatically injected when calling "by viewModels()" in fragment
) : BaseViewModel() {

    private var _movieData = mutableStateOf<LocalMovie?>(null)
    val movieData: State<LocalMovie?> = _movieData

    var _movieCredits = mutableStateListOf<LocalMovieCredits?>()
    val movieCredits: SnapshotStateList<LocalMovieCredits?> = _movieCredits

    fun getCredits(movieId: Int){
        viewModelScope.launch {
            val temp = getMovieCreditsUseCase(movieId)
            temp.apply {
                when(this){
                    is TmdbMovieCreditsResult.DefaultResult ->{
                        _movieCredits.clear()
                        _movieCredits.addAll(this.movieCredits)
                    }
                    is TmdbMovieCreditsResult.ErrorResult ->{
                        _movieCredits.clear()
                    }
                }
            }
        }
    }


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