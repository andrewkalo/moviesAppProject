package net.arx.helloworldarx.ui.moviesCategory

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.State
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import net.arx.helloworldarx.data.tmdb.local.LocalMoviesByCategory
import net.arx.helloworldarx.databinding.FragmentMoviesCategoryBinding
import net.arx.helloworldarx.ui.base.BaseFragment
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
        //val args: MoviesCategoryFragmentArgs by navArgs()
        //val category = args.category

        //viewModel.getMoviesCategory(category)

        val navigateUp: ()-> Unit = {
            findNavController().navigateUp()
        }


        setupViews(navigateUp)

    }

    private fun setupViews(navigateUp: ()->Unit){
        with(binding){
            moviesCategoryView.setContent {
                HelloWorldArxTheme {
                    MoviesCategoryScreen(viewModel, viewModel.moviesCategoryData, navigateUp)
                }
            }
        }
    }

}