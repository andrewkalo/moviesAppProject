package net.arx.helloworldarx.data.tmdb.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import net.arx.helloworldarx.data.tmdb.model.RemoteTmdbMovieModel

@Dao
interface TmdbDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun storeLocalMovie(movie: LocalMovie)

    @Query("SELECT EXISTS(SELECT * FROM movies where id=:movieId)")
    suspend fun checkIfMovieExistsLocally(movieId: Int): Boolean

    @Query("SELECT * FROM movies where id=:movieId")
    suspend fun getLocalMovie(movieId: Int): LocalMovie

}

