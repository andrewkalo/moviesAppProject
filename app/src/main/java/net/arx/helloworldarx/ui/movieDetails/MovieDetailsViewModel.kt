package net.arx.helloworldarx.ui.movieDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataModel
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import net.arx.helloworldarx.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val tmdbRepository: TmdbRepository //Automatically injected when calling "by viewModels()" in fragment
) : BaseViewModel() {

    private var _movieData = mutableStateOf<TmdbDataModel?>(null)
    val movieData: State<TmdbDataModel?> = _movieData
    fun getMovie(movieId: String){
        viewModelScope.launch{
            tmdbRepository.fetchMovie(movieId).also {
                _movieData.value = it
            }
        }
    }

}