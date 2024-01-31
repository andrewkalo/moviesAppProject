package net.arx.helloworldarx.ui.moviesCategory

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.MutableState
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import net.arx.helloworldarx.databinding.FragmentMoviesCategoryBinding
import net.arx.helloworldarx.ui.base.BaseFragment
import net.arx.helloworldarx.ui.movieDetails.MovieDetailsFragmentArgs
import net.arx.helloworldarx.ui.moviesCategory.composables.MoviesCategoryScreen
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme

class MoviesCategoryFragment : BaseFragment<FragmentMoviesCategoryBinding>(){
    private val viewModel: MoviesCategoryViewModel by viewModels()
    override fun getViewBinding(): FragmentMoviesCategoryBinding =
        FragmentMoviesCategoryBinding.inflate(layoutInflater)

    override fun getStatusBarType(): StatusBarType = StatusBarType.LIGHT

    override fun getViewMode(): ViewMode = ViewMode.FULLSCREEN

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()

    }

    private fun setupViews(){
        with(binding){
            moviesCategoryView.setContent {
                HelloWorldArxTheme {
                    MoviesCategoryScreen(view)
                }
            }
        }
    }

}