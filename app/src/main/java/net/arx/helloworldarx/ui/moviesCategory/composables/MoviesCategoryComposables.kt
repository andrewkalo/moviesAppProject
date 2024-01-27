package net.arx.helloworldarx.ui.moviesCategory.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.tooling.preview.Preview
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme
import net.arx.helloworldarx.ui.theme.SpacingCustom_24dp
import net.arx.helloworldarx.ui.theme.SpacingQuarter_4dp
import java.lang.reflect.Modifier
import androidx.compose.material3.CircularProgressIndicator
import net.arx.helloworldarx.ui.moviesCategory.model.MoviesCategoryUiState as MoviesCategoryUiState


@Composable
fun MoviesCategoryUI(numberToShow: MutableState<Int>){
    //TODO YOUR UI GOES HERE
    Row(){
        Text(text="Hello world")
        Text(text = "This number is from the viewmodel ${numberToShow.value}")
    }

    @Composable
    fun MoviesCategoryDefaultContent(MoviesCategoryUiState: MoviesCategoryUiState.DefaultUiState) {

    }

    /*
    Xtypane error
    @Composable
    fun MoviesCategoryLoadingContent() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CircularProgressIndicator(
                modifier = Modifier
                    .padding(bottom = SpacingCustom_24dp)
                    .fillMaxWidth(0.2f)
                    .aspectRatio(1f),
                strokeWidth = SpacingQuarter_4dp,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }


    @Composable
    fun MoviesCategoryContent(MoviesCategoryUiState: State<MoviesCategoryUiState>) {
        when (val currentState = MoviesCategoryUiState.value) {
            is MoviesCategoryUiState.DefaultUiState -> {
                MoviesCategoryDefaultContent(MoviesCategoryUiState = currentState)
            }

            MoviesCategoryUiState.ErrorUiState -> {
                // TODO: show error state - in cases that we might have an error
            }

            MoviesCategoryUiState.LoadingUiState -> {
                MoviesCategoryLoadingContent()
            }

            else -> {}
        }
    }


     */



    @Composable
    fun MoviesCategoryContentLoadingStatePreview() {
        val MoviesCategoryUiState = remember {
            mutableStateOf(MoviesCategoryUiState.LoadingUiState)
        }

        HelloWorldArxTheme {
            //MoviesCategoryContent(MoviesCategoryUiState = MoviesCategoryUiState)
        }
    }
}