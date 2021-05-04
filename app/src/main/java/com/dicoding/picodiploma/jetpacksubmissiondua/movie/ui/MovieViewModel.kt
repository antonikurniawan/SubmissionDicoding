package com.dicoding.picodiploma.jetpacksubmissiondua.movie.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.jetpacksubmissiondua.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.local.entity.Film


class MovieViewModel(private val filmRepository: FilmRepository): ViewModel() {
    fun getMovies(): LiveData<List<Film>> = filmRepository.getAllMovies()
}