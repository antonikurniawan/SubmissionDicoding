package com.dicoding.picodiploma.jetpacksubmissiontiga.tv.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiontiga.vo.Resource

//class TvSeriesViewModel(private val filmRepository: FilmRepository): ViewModel() {
//    fun getTvSeries(): LiveData<List<Film>> = filmRepository.getAllTv()
//}

class TvSeriesViewModel(private val filmRepository: FilmRepository): ViewModel() {
    fun getTvSeries(): LiveData<Resource<PagedList<Film>>> = filmRepository.getAllTv()
}