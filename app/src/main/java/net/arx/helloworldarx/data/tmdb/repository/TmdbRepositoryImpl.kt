package net.arx.helloworldarx.data.tmdb.repository

import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataModel
import net.arx.helloworldarx.data.tmdb.datasource.TmdbDataSource
import net.arx.helloworldarx.domain.tmdb.repository.TmdbRepository
import javax.inject.Inject

class TmdbRepositoryImpl @Inject constructor(
    private val dataSource: TmdbDataSource
) : TmdbRepository {
    override suspend fun fetchMovie(movie: String): TmdbDataModel {

        return if(!false){ // TODO Should become if not exists locally
            dataSource.fetchMovieDetails(movie)
        }else{
            //TODO GET LOCALLY HERE
            return TmdbDataModel(false,"","",null,null,"",123,null,"","",4.0,"",5,"",false,5.0,1000)
        }
    }


}