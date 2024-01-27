package net.arx.helloworldarx.framework.tmdb.datasource

import android.annotation.SuppressLint
import android.util.Log
import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits
import net.arx.helloworldarx.data.tmdb.local.TmdbDao
import net.arx.helloworldarx.framework.tmdb.api.TmdbApi
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


    override suspend fun getTopMovies(apiKey: String, page: Int) {
        tmdbApi.getTopMovies(apiKey, page)
    }

    override suspend fun getPopularMovies(apiKey: String, page: Int) {
        tmdbApi.getPopularMovies(apiKey, page)
    }


}