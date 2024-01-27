package net.arx.helloworldarx.ui.moviesCategory

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.MutableState
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.arx.helloworldarx.ui.base.BaseFragment
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme
import net.arx.helloworldarx.databinding.FragmentMoviesCategoryBinding
import net.arx.helloworldarx.ui.moviesCategory.composables.MoviesCategoryUI


@AndroidEntryPoint
class MoviesCategoryFragment : BaseFragment<FragmentMoviesCategoryBinding>(){


    private val viewModel: MoviesCategoryViewModel by viewModels()
    override fun getViewBinding(): FragmentMoviesCategoryBinding = FragmentMoviesCategoryBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO GET CategoryId/Name or something FROM NAVIGATION ARGS WHEN IT GETS IMPLEMENTED
        val categoryId = 520758

        val numberFromViewModel = viewModel.variableForUi

        showMovieCategory(numberFromViewModel)


    }

    private fun showMovieCategory(numberFromViewModel: MutableState<Int>){
        with(binding){
            moviesCategoryView.setContent {
                HelloWorldArxTheme {
                    MoviesCategoryUI(numberFromViewModel) //TODO This is where we call the composable
                }
            }
        }
    }


}

