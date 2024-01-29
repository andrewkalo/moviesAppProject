package net.arx.helloworldarx.ui.moviesCategory.model

sealed interface MoviesCategoryUiState {
    object LoadingUiState : MoviesCategoryUiState
    data class DefaultUiState(val MoviesCategoryUiType: MoviesCategoryUiType) : MoviesCategoryUiState
    data object ErrorUiState : MoviesCategoryUiState
    object EmptyUiState : MoviesCategoryUiState
}

class MoviesCategoryUiType {

}
