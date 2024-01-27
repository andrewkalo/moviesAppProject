package net.arx.helloworldarx.ui.movieDetails.composables

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import net.arx.helloworldarx.R
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.ui.movieDetails.MovieDetailsViewModel
import net.arx.helloworldarx.ui.theme.HelloWorldArxTypography
import androidx.compose.runtime.State
import androidx.compose.runtime.snapshots.SnapshotStateList
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsUI(
    movieData: State<LocalMovie?>,
    movieCreditsState: SnapshotStateList<LocalMovieCredits?>
) { //TODO Show loading thingy while fetching data, break it
    //val viewModel = hiltViewModel<MovieDetailsViewModel>()


    Scaffold(
        topBar = {
            TopAppBar(
                title = { movieData.value?.let { Text(text = it.title) } }, //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
                navigationIcon = {
                    IconButton(onClick = { /*TODO Implement back*/ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                })
        }) {
        Column(modifier = Modifier.padding(it)) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                model = "https://image.tmdb.org/t/p/w500/${movieData.value?.backdrop_path}",
                contentDescription = null,
                //contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp), horizontalArrangement = Arrangement.SpaceAround) {
                Spacer(modifier = Modifier.padding(10.dp))
                Column {
                    Text(text = stringResource(R.string.movie_popularity), style = HelloWorldArxTypography.labelMedium)
                    movieData.value?.let { it1 ->
                        Text(
                            text = it1.popularity.toString(),
                            style = HelloWorldArxTypography.headlineLarge
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Column {
                    Text(text = stringResource(id = R.string.movie_rating),style = HelloWorldArxTypography.labelMedium)
                    movieData.value?.let { it1 ->
                        Text(
                            text = it1.voteAverage.toString(),
                            style = HelloWorldArxTypography.headlineLarge
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(20.dp))
            }
            LazyRow{
                items(movieCreditsState){credit ->
                    Log.d("MyLog","Credit ${credit!!.movieId}")
                    if (credit.profilePath != null) {
                        ActorView(credit)
                    }
                }
            }

            movieData.value?.let {
                it1 -> Text(text = it1.description, style = HelloWorldArxTypography.headlineMedium, modifier = Modifier.padding(20.dp))
            } //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
            movieData.value?.let { it1 -> Text(text = it1.releaseDate) } //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MovieDetailsPre() {
    val viewModel: MovieDetailsViewModel = hiltViewModel()

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
        "asdsdfwerdsf32",
        true)
    //MovieDetailsUI({viewModel.getMovie(1234)},{viewModel.movieData})

}