package net.arx.helloworldarx.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun launch(function: suspend () -> Unit): Job {
        return viewModelScope.launch {
            function.invoke()
        }
    }
}