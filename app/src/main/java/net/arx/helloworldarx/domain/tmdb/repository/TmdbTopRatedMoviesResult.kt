package net.arx.helloworldarx.domain.tmdb.repository

import okhttp3.ResponseBody
sealed class TmdbTopRatedMoviesResult <out T>{

    data class Data<out T>(val value: T): TmdbTopRatedMoviesResult<T>()

    data class Error(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?,
        val errorMessage: String?
    ): TmdbTopRatedMoviesResult<Nothing>()

    object Loading: TmdbTopRatedMoviesResult<Nothing>()
}