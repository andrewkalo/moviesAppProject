package net.arx.helloworldarx.data.tmdb.local

import androidx.room.Database
import androidx.room.RoomDatabase
import net.arx.helloworldarx.data.tmdb.model.RemoteTmdbMovieModel

@Database(
    version = 1,
    entities = [LocalMovie::class], // TODO Add your own entities here like [LocalMovie::class, Categories::class, DashboardStuff::class]
    exportSchema = false,
    )
    abstract class TmdbDatabase : RoomDatabase() {
        abstract fun tmdbDao(): TmdbDao
}

