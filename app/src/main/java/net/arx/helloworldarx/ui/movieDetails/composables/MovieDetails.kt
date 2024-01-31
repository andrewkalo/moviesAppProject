package net.arx.helloworldarx.ui.movieDetails.composables

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
    movieCreditsState: SnapshotStateList<LocalMovieCredits?>,
    navigateUp: ()->Unit
) { //TODO Show loading thingy while fetching data, break it
    //val viewModel = hiltViewModel<MovieDetailsViewModel>()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { movieData.value?.let { Text(text = it.title) } }, //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                })
        }) {
        movieData.value?.backdrop_path?.let {
            backDrop ->
            Column(modifier = Modifier.fillMaxSize()) {
                ShowImageTitle(it, backDrop)
                ShowRattingAndPopularity(
                    popularity = movieData.value!!.popularity.toString(),
                    voteAverage = movieData.value!!.voteAverage.toString()
                )
                ShowActors(movieCreditsState = movieCreditsState)
                ShowDescription(description = movieData.value!!.description)
            }
        }
    }
        
}

@Composable
fun ShowActors(movieCreditsState: SnapshotStateList<LocalMovieCredits?>){
    LazyRow {
        items(movieCreditsState) { credit ->
            Log.d("MyLog", "Credit ${credit!!.movieId}")
            if (credit.profilePath != null) {
                ActorView(credit)
            }
        }
    }
    
}

@Composable
fun ShowDescription(description: String){
        Text(
            text = description,
            style = HelloWorldArxTypography.headlineMedium,
            modifier = Modifier.padding(20.dp).verticalScroll(rememberScrollState())
        )
    
}


@Composable
fun ShowRattingAndPopularity(popularity: String,voteAverage: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp), horizontalArrangement = Arrangement.SpaceAround
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        Column {
            Text(
                text = stringResource(R.string.movie_popularity),
                style = HelloWorldArxTypography.labelMedium
            )
                Text(
                    text = popularity,
                    style = HelloWorldArxTypography.headlineLarge
                )
            
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column {
            Text(
                text = stringResource(id = R.string.movie_rating),
                style = HelloWorldArxTypography.labelMedium
            )
            
                Text(
                    text = voteAverage,
                    style = HelloWorldArxTypography.headlineLarge
                )
            
        }
        Spacer(modifier = Modifier.padding(20.dp))
    }
}

@Composable
fun ShowImageTitle(paddingValues: PaddingValues,backDropPath: String){
    Column(modifier = Modifier.padding(paddingValues)) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            model = "https://image.tmdb.org/t/p/w500/${backDropPath}",
            contentDescription = null,
            //contentScale = ContentScale.Crop
        )
        //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
        //movieData.value?.let { it1 -> Text(text = it1.releaseDate) } //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
    }
}

