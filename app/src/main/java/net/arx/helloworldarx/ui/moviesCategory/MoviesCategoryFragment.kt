package net.arx.helloworldarx.ui.moviesCategory

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.arx.helloworldarx.databinding.FragmentDashboardBinding
import net.arx.helloworldarx.ui.base.BaseFragment
import net.arx.helloworldarx.ui.movieDetails.MovieDetailsViewModel
//import net.arx.helloworldarx.ui.moviesCategory.composables.MoviesCategoryUI
import net.arx.helloworldarx.ui.theme.HelloWorldArxTheme

class MoviesCategoryFragment : BaseFragment<FragmentDashboardBinding>(){

    override fun getViewBinding(): FragmentDashboardBinding = FragmentDashboardBinding.inflate(layoutInflater)
}