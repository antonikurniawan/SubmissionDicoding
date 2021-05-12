package com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film

@Dao
interface FilmDao {
    //movie
//    @Query("SELECT * FROM filmentities WHERE filmType = 'Movies'")
//    fun getMovies(): LiveData<List<Film>>

    @Query("SELECT * FROM filmentities WHERE filmName = :movieName AND filmType = 'Movies'")
    fun getMovieByName(movieName: String): LiveData<Film>

    //paging
    @Query("SELECT * FROM filmentities WHERE filmType = 'Movies'")
    fun getMovies(): DataSource.Factory<Int, Film>


    //tv
//    @Query("SELECT * FROM filmentities WHERE filmType = 'Tv Series'")
//    fun getTvSeries(): LiveData<List<Film>>

    @Query("SELECT * FROM filmentities WHERE filmName = :tvSeriesName AND filmType = 'Tv Series'")
    fun getTvSeriesByName(tvSeriesName: String): LiveData<Film>

    //paging
    @Query("SELECT * FROM filmentities WHERE filmType = 'Tv Series'")
    fun getTvSeries(): DataSource.Factory<Int, Film>

    //insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<Film>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvSeries(tvSeries: List<Film>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetail(movies: Film)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvSeriesDetail(tvSeries: Film)

    //update
    @Update
    fun updateMovie(movie: Film)

    @Update
    fun updateTvSeries(tvSeries: Film)

    //favorite
//    @Query("SELECT * FROM filmentities WHERE filmType = 'Movies' AND favorite = 1")
//    fun getFavoritedMovie(): LiveData<List<Film>>
//
//    @Query("SELECT * FROM filmentities WHERE filmType = 'Tv Series' AND favorite = 1")
//    fun getFavoritedTvSeries(): LiveData<List<Film>>

    //paging
    @Query("SELECT * FROM filmentities WHERE filmType = 'Movies' AND favorite = 1")
    fun getFavoritedMovie(): DataSource.Factory<Int, Film>

    @Query("SELECT * FROM filmentities WHERE filmType = 'Tv Series' AND favorite = 1")
    fun getFavoritedTvSeries(): DataSource.Factory<Int, Film>

}