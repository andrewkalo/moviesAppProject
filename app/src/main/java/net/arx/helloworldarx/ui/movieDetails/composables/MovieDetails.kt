package net.arx.helloworldarx.ui.movieDetails.composables

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.ktx.Resource
import net.arx.helloworldarx.R
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.ui.movieDetails.MovieDetailsViewModel
import net.arx.helloworldarx.ui.theme.HelloWorldArxTypography
import net.arx.helloworldarx.usecase.movieDetails.GetMovieDataUseCase

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun MovieDetailsUI(movieId: Int) { //TODO Show loading thingy while fetching data, break it
    val viewModel = hiltViewModel<MovieDetailsViewModel>()
    viewModel.getMovie(movieId)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { viewModel.movieData.value?.let { Text(text = it.title) } }, //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
                navigationIcon = {
                    IconButton(onClick = { /*TODO Implement back*/ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                })
        }) {
        Column(modifier = Modifier.padding(it)) {
            GlideImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                model = "https://image.tmdb.org/t/p/w500/${viewModel.movieData.value?.imagePath}",
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier.fillMaxWidth().padding(20.dp), horizontalArrangement = Arrangement.SpaceAround) {
                Spacer(modifier = Modifier.padding(20.dp))
                Column {
                    Text(text = stringResource(R.string.movie_popularity), style = HelloWorldArxTypography.labelMedium)
                    viewModel.movieData.value?.let { it1 ->
                        Text(
                            text = it1.popularity.toString(),
                            style = HelloWorldArxTypography.headlineLarge
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Column {
                    Text(text = stringResource(id = R.string.movie_rating),style = HelloWorldArxTypography.labelMedium)
                    viewModel.movieData.value?.let { it1 ->
                        Text(
                            text = it1.voteAverage.toString(),
                            style = HelloWorldArxTypography.headlineLarge
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(20.dp))
            }

            viewModel.movieData.value?.let {
                it1 -> Text(text = it1.description, style = HelloWorldArxTypography.headlineMedium, modifier = Modifier.padding(20.dp))
            } //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
            viewModel.movieData.value?.let { it1 -> Text(text = it1.releaseDate) } //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MovieDetailsPre() {
    val movieData = LocalMovie(
        12,
        "",
        "Chicken Run: Dawn of the Nugget",
        "5/10/1999",
        5.5,
        5,
        55,
        5.4,
        "English",
        "/asdsdfwerdsf32",
        true
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { movieData?.let { Text(text = it.title) } }, //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
                navigationIcon = {
                    IconButton(onClick = { /*TODO Implement back*/ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                })
        }) {
        Row(modifier = Modifier.padding(it)) {
            Column {
                Text(text = "")
                movieData?.let { it1 -> Text(text = it1.originalLanguage) } //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
                movieData?.let { it1 -> Text(text = it1.releaseDate) } //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
            }
        }

    }

}