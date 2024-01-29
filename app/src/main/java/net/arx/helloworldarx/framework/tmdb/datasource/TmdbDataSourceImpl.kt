package net.arx.helloworldarx.framework.tmdb.datasource

import android.annotation.SuppressLint
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.flowOn
import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits
import net.arx.helloworldarx.data.tmdb.local.LocalMoviesByCategory
import net.arx.helloworldarx.data.tmdb.local.TmdbDao
import net.arx.helloworldarx.data.tmdb.model.TopRatedMoviesResponse
import net.arx.helloworldarx.domain.tmdb.repository.TmdbTopRatedMoviesResult
import net.arx.helloworldarx.framework.tmdb.api.TmdbApi
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class TmdbDataSourceImpl @Inject constructor(
    private val tmdbApi: TmdbApi,
    private val tmdbDao: TmdbDao
) : TmdbDataSource {
    @SuppressLint("LogNotTimber")
    override suspend fun fetchMovie(movieId: Int): LocalMovie {
        return if (tmdbDao.checkIfMovieExistsLocally(movieId)) {
            Log.d("MyLog", "Got it from local")
            return tmdbDao.getLocalMovie(movieId)

        }else{
            Log.d("MyLog","Got it from remote")
            val remoteMovie = tmdbApi.fetchMovieFromApi(movieId)
            tmdbDao.storeLocalMovie(remoteMovie.toLocalMovie())
            remoteMovie.toLocalMovie()
        }
    }

    override suspend fun fetchMovieCredits(movieId: Int): List<LocalMovieCredits> {
        tmdbDao.storeLocalMovieCredits(tmdbApi.fetchMovieCredits(movieId).toLocalCredits())
        return tmdbApi.fetchMovieCredits(movieId).toLocalCredits()
    }

    override suspend fun fetchMoviesByCategory(categoryId: Int): List<LocalMoviesByCategory> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopRatedMovies(lang: String, page: Int): Flow<TmdbTopRatedMoviesResult<TopRatedMoviesResponse>> {
        return flow {
            emit(TmdbTopRatedMoviesResult.Loading)
            try {
                val response = tmdbApi.getTopRatedMovies(
                    page = page, language = lang
                )
                emit(
                    TmdbTopRatedMoviesResult.Data(response)
                )
            } catch (throwable: Throwable) {
                emit(
                    when (throwable) {
                        is HttpException -> {
                            TmdbTopRatedMoviesResult.Error(
                                false,
                                throwable.code(),
                                throwable.response()?.errorBody(),
                                throwable.response()?.message()
                            )
                        }
                        is IOException -> {
                            TmdbTopRatedMoviesResult.Error(true, null, null,null)
                        }
                        else -> {
                            TmdbTopRatedMoviesResult.Error(false, null, null, null)
                        }
                    }
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetchPopularMovies(): List<LocalMovie> {
        TODO("Not yet implemented")
    }

    // To override dinei lathos
    /*suspend fun getTopMovies(): List<LocalMovie>? {
        val remoteMovieList = tmdbApi.fetchTopMovies()
        val remoteMovie = remoteMovieList.first()
        tmdbDao.storeLocalMovie(remoteMovie.toLocalMovie())
        var list : List<LocalMovie>? = null
        if (list != null) {
            list = list +  remoteMovie.toLocalMovie()
        }
        return list
    }*/

    // To override dinei lathos
    /*suspend fun getPopularMovies(): List<LocalMovie>? {
        val remoteMovieList = tmdbApi.fetchPopularMovies()
        val remoteMovie = remoteMovieList.first()
        tmdbDao.storeLocalMovie(remoteMovie.toLocalMovie())
        var list : List<LocalMovie>? = null
        if (list != null) {
            list = list +  remoteMovie.toLocalMovie()
        }
        return list
    }*/


}