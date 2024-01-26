package net.arx.helloworldarx.ui.moviesCategory

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import androidx.core.view.isVisible
import net.arx.helloworldarx.databinding.FragmentDashboardBinding
import net.arx.helloworldarx.ui.base.BaseFragment
//import net.arx.helloworldarx.ui.base.StatusBarType
//import net.arx.helloworldarx.ui.base.ViewMode
import net.arx.helloworldarx.ui.movieDetails.MovieDetailsViewModel
import net.arx.helloworldarx.ui.splash.SplashViewModel
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import net.arx.helloworldarx.ui.moviesCategory.model.MoviesCategoryUiState
import net.arx.helloworldarx.ui.splash.model.SplashUiState

class MoviesCategoryFragment : BaseFragment<FragmentDashboardBinding>(){


    //private val viewModel: MoviesCategoryViewModel by viewModels()
    override fun getViewBinding(): FragmentDashboardBinding = FragmentDashboardBinding.inflate(layoutInflater)

    override fun getStatusBarType(): StatusBarType = StatusBarType.LIGHT

    override fun getViewMode(): ViewMode = ViewMode.FULLSCREEN


    private fun setupViews() {
        //Add View related code here

    }

    /*
    private fun setupObservers() {
        with(viewModel) {
            moviesCategoryUi.observe(viewLifecycleOwner, Observer(::handleSplashUiItem))
        }
    }

    private fun handleMoviesCategoryUiItem(MoviesCategoryUiState: MoviesCategoryUiState) {
        when (MoviesCategoryUiState) {
            is MoviesCategoryUiState.DefaultUiState ->
                handleMoviesCategoryDefaultUiState(MoviesCategoryUiState = MoviesCategoryUiState)
            MoviesCategoryUiState.ErrorUiState -> {}
            MoviesCategoryUiState.LoadingUiState -> handleMoviesCategoryLoadingUiState()
        }
    }


    private fun handleMoviesCategoryDefaultUiState(moviesCategory: MoviesCategoryUiState.DefaultUiState) {
        with(binding) {

        }
    }

    private fun handleMoviesCategoryLoadingUiState() {
        with(binding) {

        }
    }

    */

}

