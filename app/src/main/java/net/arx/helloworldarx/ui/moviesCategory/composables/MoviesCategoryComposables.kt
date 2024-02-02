package net.arx.helloworldarx.ui.moviesCategory.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import net.arx.helloworldarx.ui.theme.SpacingCustom_24dp
import net.arx.helloworldarx.ui.theme.SpacingQuarter_4dp
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import net.arx.helloworldarx.R
import net.arx.helloworldarx.data.tmdb.local.LocalMoviesByCategory
import net.arx.helloworldarx.ui.moviesCategory.MoviesCategoryFragmentDirections
import net.arx.helloworldarx.ui.moviesCategory.MoviesCategoryViewModel
import net.arx.helloworldarx.ui.theme.HelloWorldArxTypography
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
internal fun MoviesCategoryScreen(
    viewModel: MoviesCategoryViewModel = hiltViewModel(),
    moviesCategoryData: List<LocalMoviesByCategory?>,
    navigateUp: ()->Unit) {

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
                    IconButton(onClick = { navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                })
        }) {
        LazyColumn(modifier = androidx.compose.ui.Modifier.padding(it)) {
            if (viewModel.isLoadingMoviesCategory.value) {
                item {
                    CircularProgressIndicator(
                        modifier = androidx.compose.ui.Modifier
                            .padding(bottom = SpacingCustom_24dp)
                            .fillMaxWidth(0.2f)
                            .aspectRatio(1f),
                        strokeWidth = SpacingQuarter_4dp,
                        color = MaterialTheme.colorScheme.primary
                    )

                }
            }else if(viewModel.errorLoadingMoviesCategory.value) {
                item {
                    Image(
                        modifier = androidx.compose.ui.Modifier
                            .fillMaxWidth(0.2f)
                            .aspectRatio(1f)
                            .fillMaxHeight(0.3f),
                        painter = painterResource(id = R.drawable.error),
                        contentDescription = stringResource(id = R.string.empty)
                    )

                    Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))
                    Column(
                        modifier = androidx.compose.ui.Modifier.padding(it)
                    ) {
                        Text(
                            text = "ERROR. No internet connection",
                            style = HelloWorldArxTypography.headlineLarge
                        )
                    }
                }
            }
            else if(viewModel.emptyLoadingMoviesCategory.value){
                item{
                    Column(
                        modifier = androidx.compose.ui.Modifier.padding(it)
                    ) {
                        Image(
                            modifier = androidx.compose.ui.Modifier
                                .fillMaxWidth(0.2f)
                                .aspectRatio(1f)
                                .fillMaxHeight(0.3f),
                            painter = painterResource(id = R.drawable.error),
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
            /*
            else {
                item {
                    AsyncImage(
                        modifier = androidx.compose.ui.Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.3f)
                            .clickable(onClick = {movie.id?.let {navController.navigate(
                            MoviesCategoryFragmentDirections.actionMoviesCategoryViewToMovieDetailsView()) }
                            }),
                        model = "https://image.tmdb.org/t/p/w500/${moviesCategoryData.value?.backdrop_path}",
                        contentDescription = null
                    )
                    moviesCategoryData.value?.let { it1 ->
                        Text(
                            text = it1.original_title,
                            style = HelloWorldArxTypography.headlineLarge
                        )
                    }
                    Spacer(modifier = androidx.compose.ui.Modifier.height(10.dp))
                }
            }

             */


        }
    }



}





