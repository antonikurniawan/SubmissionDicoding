package com.dicoding.picodiploma.jetpacksubmissiondua.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.jetpacksubmissiondua.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiondua.utils.DataDummy

class DetailFilmViewModel (private val filmRepository: FilmRepository): ViewModel() {
    private lateinit var filmName: String

    fun setSelectedFilm(filmName: String){
        this.filmName = filmName
    }


    fun getMovie(): LiveData<Film> = filmRepository.getMoviesWithName(filmName)

    fun getTv(): LiveData<Film> = filmRepository.getTvWithName(filmName)

}