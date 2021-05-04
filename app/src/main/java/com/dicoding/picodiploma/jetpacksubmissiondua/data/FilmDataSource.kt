package com.dicoding.picodiploma.jetpacksubmissiondua.data

import androidx.lifecycle.LiveData
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.local.entity.Film

interface FilmDataSource {

    //movie
    fun getAllMovies(): LiveData<List<Film>>

    fun getMoviesWithName(movieName: String): LiveData<Film>

    //tv
    fun getAllTv(): LiveData<List<Film>>

    fun getTvWithName(tvName: String): LiveData<Film>
}