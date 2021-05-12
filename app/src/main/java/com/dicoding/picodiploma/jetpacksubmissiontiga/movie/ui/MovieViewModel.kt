package com.dicoding.picodiploma.jetpacksubmissiontiga.movie.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiontiga.vo.Resource


//class MovieViewModel(private val filmRepository: FilmRepository): ViewModel() {
//    fun getMovies(): LiveData<List<Film>> = filmRepository.getAllMovies()
//}

class MovieViewModel(private val filmRepository: FilmRepository): ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<Film>>> = filmRepository.getAllMovies()
}