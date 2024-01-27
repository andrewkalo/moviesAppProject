package net.arx.helloworldarx.ui.movieDetails

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.arx.helloworldarx.databinding.FragmentMovieDetailsBinding
import net.arx.helloworldarx.ui.base.BaseFragment
import net.arx.helloworldarx.ui.movieDetails.composables.MovieDetailsUI
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme

@AndroidEntryPoint
class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>() {

    private val viewModel: MovieDetailsViewModel by viewModels() //Create the ViewModel with its injected properties
    override fun getViewBinding(): FragmentMovieDetailsBinding = FragmentMovieDetailsBinding.inflate(layoutInflater)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO GET MOVIE FROM NAVIGATION ARGS WHEN IT GETS IMPLEMENTED
        val movieId = 520758
        viewModel.getMovie(movieId)
        viewModel.getCredits(movieId)

        Log.d("MyLog","Size ${viewModel.movieCredits.size}")

        ShowMovieDetailsUI()
    }
    private fun ShowMovieDetailsUI(){
        with(binding){
            movieDetailsView.setContent {
                HelloWorldArxTheme {
                    MovieDetailsUI(
                        viewModel.movieData,
                        viewModel.movieCredits
                    )
                }
            }
        }
    }

}