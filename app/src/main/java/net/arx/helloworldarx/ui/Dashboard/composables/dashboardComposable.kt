package net.arx.helloworldarx.ui.Dashboard.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ProduceStateDoesNotAssignValue")
@Composable
fun DashboardUI() {



    //Dokimastiki lista me ta banners tainiwn
    val imageList = List(10) { index ->
        when (index) {
            0 -> "pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg"
            1 -> "u6oXUTtOuJRPdUgUuPAVVJPSKCo.jpg"
            2 -> "k7eYdWvhYQyRQoU2TB2A2Xu2TfD.jpg"
            3 -> "yz4QVqPx3h1hD1DfqqQkCq3rmxW.jpg"
            4 -> "oyG9TL7FcRP4EZ9Vid6uKzwdndz.jpg"
            5 -> "pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg"
            6 -> "u6oXUTtOuJRPdUgUuPAVVJPSKCo.jpg"
            7 -> "k7eYdWvhYQyRQoU2TB2A2Xu2TfD.jpg"
            8 -> "yz4QVqPx3h1hD1DfqqQkCq3rmxW.jpg"
            9 -> "oyG9TL7FcRP4EZ9Vid6uKzwdndz.jpg"
            else -> "gEU2QniE6E77NI6lCU6MxlNBvIx.jpg"
        }
    }
    //To top app bar
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Dashboard") },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            //Top 10 Movies Section
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Top 10 Movies",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    TextButton(
                        onClick = { /*TODO When Clicked Go to The Top 10 Movies Fragment*/ }
                    ) {
                        Text(
                            text = "See All",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
                LazyRow {
                    items(imageList) { image ->
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.5f),
                            model = "https://image.tmdb.org/t/p/w500/${image}",
                            contentDescription = null,
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
            }

            // Popular Movies Section
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Popular Movies",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    TextButton(
                        onClick = { /*TODO When Clicked Go to The Popular Movies Fragment*/ }
                    ) {
                        Text(
                            text = "See All",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
                LazyRow {
                    items(imageList) { image ->
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.5f),
                            model = "https://image.tmdb.org/t/p/w500/$image",
                            contentDescription = null,
                        )
                    }
                }
            }

            // Spacer to separate the two sections
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }

            // Horror Movies Section
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Horror Movies",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    TextButton(
                        onClick = { /*TODO When Clicked Go to The Horror Movies Fragment*/ }
                    ) {
                        Text(
                            text = "See All",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
                LazyRow {
                    items(imageList) { image ->
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.5f),
                            model = "https://image.tmdb.org/t/p/w500/$image",
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }
}