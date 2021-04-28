package com.dicoding.picodiploma.jetpacksubmissiondua

import androidx.lifecycle.ViewModel

class TvSeriesViewModel: ViewModel() {
    fun getTvSeries(): List<Film> = DataDummy.generateDummyTvSeries()
}