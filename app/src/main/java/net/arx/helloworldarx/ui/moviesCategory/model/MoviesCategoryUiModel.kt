package net.arx.helloworldarx.ui.moviesCategory.model

sealed interface MoviesCategoryUiState {
    class DefaultUiState(val MoviesCategoryUiType: MoviesCategoryUiType) : MoviesCategoryUiState
    object ErrorUiState : MoviesCategoryUiState
    object LoadingUiState : MoviesCategoryUiState

    object EmptyUiState : MoviesCategoryUiState
}

class MoviesCategoryUiType {

}
