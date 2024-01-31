package net.arx.helloworldarx.ui.movieDetails

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import net.arx.helloworldarx.R
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
        //TODO Here we get the navigation arguments
        val args: MovieDetailsFragmentArgs by navArgs()
        val movieId = args.movieId

        viewModel.getMovie(movieId)
        viewModel.getCredits(movieId)
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