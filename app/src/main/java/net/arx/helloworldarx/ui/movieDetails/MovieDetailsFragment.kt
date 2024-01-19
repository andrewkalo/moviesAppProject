package net.arx.helloworldarx.ui.movieDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.arx.helloworldarx.databinding.FragmentDashboardBinding
import net.arx.helloworldarx.ui.base.BaseFragment
import net.arx.helloworldarx.ui.movieDetails.composables.MovieDetailsUI
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme


@AndroidEntryPoint
class MovieDetailsFragment : BaseFragment<FragmentDashboardBinding>() {

    private val viewModel: MovieDetailsViewModel by viewModels() //Create the ViewModel with its injected properties
    override fun getViewBinding(): FragmentDashboardBinding = FragmentDashboardBinding.inflate(layoutInflater)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO GET MOVIE FROM NAVIGATION ARGS WHEN IT GETS IMPLEMENTED
        val movieId = "520758"

        ShowMovieDetailsUI(movieId)
    }
    private fun ShowMovieDetailsUI(movieId: String){
        with(binding){
            movieDetailsView.setContent {
                HelloWorldArxTheme {
                    MovieDetailsUI(viewModel,movieId)
                }
            }
        }
    }

}