package net.arx.helloworldarx.data.tmdb.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TmdbDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeLocalMovie(movie: LocalMovie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeLocalMovieCredits(credits: List<LocalMovieCredits>)

    @Query("SELECT EXISTS(SELECT * FROM movies where id=:movieId)")
    suspend fun checkIfMovieExistsLocally(movieId: Int): Boolean

    @Query("SELECT * FROM movies where id=:movieId")
    suspend fun getLocalMovie(movieId: Int): LocalMovie


    @Query("SELECT * FROM movies ORDER BY voteAverage")
    suspend fun getTopMovies(apiKey: String, page: Int): LocalMovie

    @Query("SELECT * FROM movies ORDER BY popularity")
    suspend fun getPopularMovies(apiKey: String, page: Int): LocalMovie


}

