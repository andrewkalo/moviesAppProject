package net.arx.helloworldarx.ui.moviesCategory


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.ui.base.BaseViewModel
import net.arx.helloworldarx.usecase.moviesCategory.GetLocalMoviesByCategoryUseCase
import javax.inject.Inject

@HiltViewModel
class MoviesCategoryViewModel @Inject constructor(
    private val getLocalMoviesByCategoryUseCase: GetLocalMoviesByCategoryUseCase
):BaseViewModel(){

    val MoviesCategoryStateFlowUi: MoviesCategoryViewModel
        get() {
            TODO()
        }
    private var _movieData = mutableStateOf<LocalMovie?>(null)
    val movieData: State<LocalMovie?> = _movieData

    //TODO OR SOMETHING MORE SIMPLE LIKE
    var variableForUi = mutableStateOf(1234)




}