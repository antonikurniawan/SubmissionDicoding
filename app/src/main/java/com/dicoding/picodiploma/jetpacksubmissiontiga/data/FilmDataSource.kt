package com.dicoding.picodiploma.jetpacksubmissiontiga.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiontiga.vo.Resource

interface FilmDataSource {

    //movie
//    fun getAllMovies(): LiveData<Resource<List<Film>>>

    fun getMovieWithName(movieName: String): LiveData<Resource<Film>>

    //paging
    fun getAllMovies(): LiveData<Resource<PagedList<Film>>>


    //tv
//    fun getAllTv(): LiveData<Resource<List<Film>>>

    fun getTvSeriesWithName(tvSeriesName: String): LiveData<Resource<Film>>

    //paging
    fun getAllTv(): LiveData<Resource<PagedList<Film>>>




    //set favorite
    fun setFavoriteMovie(movie: Film, state: Boolean)

    fun setFavoriteTv(tvSeries: Film, state: Boolean)

    //get favorite
//    fun getFavoriteMovie(): LiveData<List<Film>>
//
//    fun getFavoriteTvSeries(): LiveData<List<Film>>

    //paging
    fun getFavoriteMovie(): LiveData<PagedList<Film>>

    fun getFavoriteTvSeries(): LiveData<PagedList<Film>>

}