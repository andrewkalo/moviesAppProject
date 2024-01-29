package net.arx.helloworldarx.framework.tmdb.datasource

import android.annotation.SuppressLint
import android.util.Log
import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.data.tmdb.local.LocalMovie
import net.arx.helloworldarx.data.tmdb.local.LocalMovieCredits
import net.arx.helloworldarx.data.tmdb.local.LocalMoviesByCategory
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

    override suspend fun fetchMoviesByCategory(categoryId: Int): List<LocalMoviesByCategory> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchTopMovies(): List<LocalMovie> {
        var list = tmdbApi.fetchTopMovies()
        var counter = 0
        while (counter <= list.size){
            tmdbDao.storeLocalMovie(list[counter].toLocalMovie())
            counter++
        }
        return list.map { it.toLocalMovie() }
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