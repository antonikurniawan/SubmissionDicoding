package com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {
    companion object {
        private var INSTANCE: LocalDataSource?= null
        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao).apply {
                INSTANCE = this
            }
    }

    //movies
    fun getAllMovies(): DataSource.Factory<Int, Film> = mFilmDao.getMovies()

    fun getMovieByName(movieName: String): LiveData<Film> = mFilmDao.getMovieByName(movieName)


    //tv series
    fun getAllTvSeries(): DataSource.Factory<Int, Film> = mFilmDao.getTvSeries()

    fun getTvSeriesByName(tvSeriesName: String): LiveData<Film> = mFilmDao.getTvSeriesByName(tvSeriesName)


    //insert
    fun insertMovies(movies: List<Film>) = mFilmDao.insertMovies(movies)

    fun insertTvSeries(tvSeries: List<Film>) = mFilmDao.insertTvSeries(tvSeries)

    fun insertMoviesByName(movies: Film) = mFilmDao.insertMovieDetail(movies)

    fun insertTvSeriesByName(tvSeries: Film) = mFilmDao.insertTvSeriesDetail(tvSeries)


    //set favorite
    fun setMovieFavorite(movie: Film, newState: Boolean) {
        movie.favorited = newState
        mFilmDao.updateMovie(movie)
    }

    fun setTvSeriesFavorite(tvSeries: Film, newState: Boolean) {
        tvSeries.favorited = newState
        mFilmDao.updateTvSeries(tvSeries)
    }

    //get favorite
    fun getFavoriteMovies(): DataSource.Factory<Int, Film> = mFilmDao.getFavoritedMovie()

    fun getFavoriteTvSeries(): DataSource.Factory<Int, Film> = mFilmDao.getFavoritedTvSeries()

}