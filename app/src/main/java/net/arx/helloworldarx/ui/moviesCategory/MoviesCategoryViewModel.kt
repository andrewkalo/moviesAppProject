package net.arx.helloworldarx.ui.moviesCategory


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.ui.base.BaseViewModel
import net.arx.helloworldarx.ui.moviesCategory.model.MoviesCategoryUiState
import net.arx.helloworldarx.ui.moviesCategory.model.MoviesCategoryUiType
import net.arx.helloworldarx.usecase.moviesCategory.GetLocalMoviesByCategoryUseCase
import javax.inject.Inject

@HiltViewModel
class MoviesCategoryViewModel @Inject constructor(
    private val getLocalMoviesByCategoryUseCase: GetLocalMoviesByCategoryUseCase
):BaseViewModel(){

    private var _movieData = mutableStateOf<LocalMovie?>(null)
    val movieData: State<LocalMovie?> = _movieData

    //TODO OR SOMETHING MORE SIMPLE LIKE
    var variableForUi = mutableStateOf(1234)


    private val _MoviesCategoryUi = MutableLiveData<MoviesCategoryUiState>()
    val MoviesCategoryUi: LiveData<MoviesCategoryUiState> = _MoviesCategoryUi


    private val _MoviesCategoryStateUi: MutableState<MoviesCategoryUiState> =
        mutableStateOf(MoviesCategoryUiState.LoadingUiState)
    val MoviesCategoryStateUi: State<MoviesCategoryUiState> = _MoviesCategoryStateUi


    private val _MoviesCategoryStateFlowUi: MutableStateFlow<MoviesCategoryUiState> =
        MutableStateFlow(MoviesCategoryUiState.LoadingUiState)
    val MoviesCategoryStateFlowUi = _MoviesCategoryStateFlowUi.asStateFlow()


    fun initMoviesCategory() {
        launch {
            /*
            _MoviesCategoryUi.value = MoviesCategoryUiState.LoadingUiState
            delay(3000)
            _MoviesCategoryUi.value = MoviesCategoryUiState
            _MoviesCategoryStateUi.value = MoviesCategoryUiState.DefaultUiState()
            _MoviesCategoryStateFlowUi.update { MoviesCategoryUiState }

             */
        }
    }



}