package net.arx.helloworldarx.ui.moviesCategory


import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import net.arx.helloworldarx.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesCategoryViewModel @Inject constructor(
    //TODO HERE YOU NEED TO ADD STUFF TO BE INJECTED AUTOMATICALLY
    //eg private val usecase : yourUsecase
):BaseViewModel(){


    //TODO HERE WE STORE GET DATA/ STORE VARIABLES FOR OUR VIEWS
    //eg movieData = getMovieDataFromRepository()


    //TODO OR SOMETHING MORE SIMPLE LIKE
    var variableForUi = mutableStateOf(1234)



}