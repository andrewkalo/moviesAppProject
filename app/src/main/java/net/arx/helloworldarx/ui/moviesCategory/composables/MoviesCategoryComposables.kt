package net.arx.helloworldarx.ui.moviesCategory.composables

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import net.arx.helloworldarx.R
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.ui.Dashboard.DashboardFragment
import net.arx.helloworldarx.ui.movieDetails.composables.ActorView
import net.arx.helloworldarx.ui.moviesCategory.model.MoviesCategoryUiType
import net.arx.helloworldarx.ui.theme.HelloWorldArxTypography
import net.arx.helloworldarx.ui.moviesCategory.model.MoviesCategoryUiState as MoviesCategoryUiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesCategoryUI(movieData: State<LocalMovie?>) {

    @Composable
    fun MoviesCategoryDefaultContent() {
        //TODO YOUR UI GOES HERE
        Scaffold(
            topBar = {
                TopAppBar(
                    // Dokimastiko onoma titlou
                    title = { Text(text = "Top 10 movies") }, //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    navigationIcon = {
                        IconButton(onClick = {

                        }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = null)
                        }
                    })
            }) {
            LazyColumn(modifier = androidx.compose.ui.Modifier.padding(it)) {
                item {
                    AsyncImage(
                        modifier = androidx.compose.ui.Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.3f),
                        model = "https://image.tmdb.org/t/p/w500/${movieData.value?.backdrop_path}",
                        contentDescription = null
                    )
                    movieData.value?.let {it1 ->
                        Text(
                            text = it1.title,
                            style = HelloWorldArxTypography.headlineLarge
                        )
                    }
                }
                item {
                    Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))
                }
            }
        }
    }


        @Composable
        fun MoviesCategoryLoadingContent() {
            Column(
                modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CircularProgressIndicator(
                    modifier = androidx.compose.ui.Modifier
                        .padding(bottom = SpacingCustom_24dp)
                        .fillMaxWidth(0.2f)
                        .aspectRatio(1f),
                    strokeWidth = SpacingQuarter_4dp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        @Composable
        fun MoviesCategoryErrorContent() {
            Scaffold(
                topBar = {
                    TopAppBar(
                        // Dokimastiko onoma titlou
                        title = { Text(text = "Top 10 movies") }, //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.primary,
                        ),
                        navigationIcon = {
                            IconButton(onClick = { /*TODO Implement back*/ }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = null)
                            }
                        })
                }){
                Column(modifier = androidx.compose.ui.Modifier.padding(it)) {
                    // Dokimastiko
                    CircularProgressIndicator(
                        modifier = androidx.compose.ui.Modifier
                            .padding(bottom = SpacingCustom_24dp)
                            .fillMaxWidth(0.2f)
                            .aspectRatio(1f),
                        strokeWidth = SpacingQuarter_4dp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

        }


        @Composable
        fun MoviesCategoryEmptyContent() {
            Scaffold(
                topBar = {
                    TopAppBar(
                        // Dokimastiko onoma titlou
                        title = { Text(text = "Top 10 movies") }, //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.primary,
                        ),
                        navigationIcon = {
                            IconButton(onClick = { /*TODO Implement back*/ }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = null)
                            }
                        })
                }) {
                Column(
                    modifier = androidx.compose.ui.Modifier.padding(it)
                ) {
                    Image(
                        modifier = androidx.compose.ui.Modifier
                            .fillMaxWidth(0.2f)
                            .aspectRatio(1f),
                        // Dokimastikh foto
                        painter = painterResource(id = R.drawable.ic_croissant),
                        contentDescription = stringResource(id = R.string.empty)
                    )
                }
                Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))
                Column(
                    modifier = androidx.compose.ui.Modifier.padding(it)
                ){
                        Text(text = "This list is empty",
                            style = HelloWorldArxTypography.headlineLarge
                        )
                    }

                }
            }


            @Composable
            fun MoviesCategoryContent(MoviesCategoryUiState: State<MoviesCategoryUiState>) {
                when (val currentState = MoviesCategoryUiState.value) {
                    is MoviesCategoryUiState.DefaultUiState -> {
                        MoviesCategoryDefaultContent()
                    }

                    is MoviesCategoryUiState.ErrorUiState -> {
                        MoviesCategoryErrorContent()
                    }

                    is MoviesCategoryUiState.LoadingUiState -> {
                        MoviesCategoryLoadingContent()
                    }

                    is MoviesCategoryUiState.EmptyUiState -> {
                        MoviesCategoryEmptyContent()
                    }
                }
            }

            /*
        @Composable
        fun MoviesCategoryContentPreview() {
            val MoviesCategoryUiState = remember {
                mutableStateOf(MoviesCategoryUiState.DefaultUiState(MoviesCategoryUiType: MoviesCategoryUiType))
            }

            HelloWorldArxTheme {
                MoviesCategoryContent(MoviesCategoryUiState = MoviesCategoryUiState)
            }
        }

         */

            @Composable
            fun MoviesCategoryContentLoadingStatePreview() {
                val MoviesCategoryUiState = remember {
                    mutableStateOf(MoviesCategoryUiState.LoadingUiState)
                }

                HelloWorldArxTheme {
                    MoviesCategoryContent(MoviesCategoryUiState = MoviesCategoryUiState)
                }
            }
}




