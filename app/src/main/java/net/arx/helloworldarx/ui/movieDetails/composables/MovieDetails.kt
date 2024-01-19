package net.arx.helloworldarx.ui.movieDetails.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataModel
import net.arx.helloworldarx.ui.movieDetails.MovieDetailsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsUI(viewModel: MovieDetailsViewModel,movieId: String){ //TODO Show loading thingy while fetching data, break it
    viewModel.getMovie(movieId)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { viewModel.movieData.value?.let { Text(text = it.title ) } }, //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
                navigationIcon = { IconButton(onClick = { /*TODO Implement back*/ }) {
                    Icon(Icons.Default.ArrowBack,contentDescription = null)
                }})
        }){
        Row(modifier = Modifier.padding(it)){
            Column {
                Text(text = "")
                viewModel.movieData.value?.let { it1 -> Text(text = it1.originalLanguage) } //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
                viewModel.movieData.value?.let { it1 -> Text(text = it1.releaseDate) } //TODO MAKE IT NON NULLABLE BY ADDING A LOADING STATE
            }
        }

    }
}