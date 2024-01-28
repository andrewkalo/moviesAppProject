package net.arx.helloworldarx.ui.moviesCategory.composables

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.tooling.preview.Preview
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme
import net.arx.helloworldarx.ui.theme.SpacingCustom_24dp
import net.arx.helloworldarx.ui.theme.SpacingQuarter_4dp
import java.lang.reflect.Modifier
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import net.arx.helloworldarx.R
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.ui.movieDetails.composables.ActorView
import net.arx.helloworldarx.ui.theme.HelloWorldArxTypography
import net.arx.helloworldarx.ui.moviesCategory.model.MoviesCategoryUiState as MoviesCategoryUiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesCategoryUI(numberToShow: MutableState<Int>, movieData: State<LocalMovie?>,
                     moviesCategory: MutableState<String> ){

    /*
    Xtypane error

    //TODO YOUR UI GOES HERE
    Scaffold(
        topBar = {
            TopAppBar(
                title = { moviesCategory.value?.let { Text(text = it.title) } }, //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
                navigationIcon = {
                    IconButton(onClick = { /*TODO Implement back*/ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                })
        }) {
        Column(modifier = androidx.compose.ui.Modifier.padding(it)) {
            AsyncImage(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                model = "https://image.tmdb.org/t/p/w500/${movieData.value?.backdrop_path}",
                contentDescription = null
            )
        }
        Row() {
            Text(text = "Hello world")
            Text(text = "This number is from the viewmodel ${numberToShow.value}")
        }
    }

        @Composable
        fun MoviesCategoryDefaultContent(MoviesCategoryUiState: MoviesCategoryUiState.DefaultUiState) {

        }


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


