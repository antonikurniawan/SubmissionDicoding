package com.dicoding.picodiploma.jetpacksubmissiondua

import androidx.lifecycle.ViewModel

class MovieViewModel: ViewModel() {
    fun getMovies(): List<Film> = DataDummy.generateDummyMovie()
}