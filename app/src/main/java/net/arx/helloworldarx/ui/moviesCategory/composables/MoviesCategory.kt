package net.arx.helloworldarx.ui.moviesCategory.composables

import android.content.Intent
import android.media.Image
import android.os.Bundle
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
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import net.arx.helloworldarx.R
import net.arx.helloworldarx.ui.movieDetails.MovieDetailsViewModel


class MoviesCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movies_category)

        val backDash = findViewById<ImageButton>(R.id.backButton)
        backDash.setOnClickListener {
            // To dashBoard einai to onoma klashs tou arxeio sto dashboard.kt
            //val Intent = Intent(this, dashBoard::class.java)
            //startActivity(Intent)
        }
    }
}

