package com.dicoding.picodiploma.jetpacksubmissiondua.tv.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.jetpacksubmissiondua.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.local.entity.Film

class TvSeriesViewModel(private val filmRepository: FilmRepository): ViewModel() {
    fun getTvSeries(): LiveData<List<Film>> = filmRepository.getAllTv()
}