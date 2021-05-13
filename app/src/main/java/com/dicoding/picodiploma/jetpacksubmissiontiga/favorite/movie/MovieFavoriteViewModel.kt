package com.dicoding.picodiploma.jetpacksubmissiontiga.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film

class MovieFavoriteViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getFavorites(): LiveData<PagedList<Film>> {
        return filmRepository.getFavoriteMovie()
    }
}