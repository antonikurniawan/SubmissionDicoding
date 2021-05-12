package com.dicoding.picodiploma.jetpacksubmissiontiga.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiontiga.vo.Resource


class DetailFilmViewModel (private val filmRepository: FilmRepository): ViewModel() {
    var filmName = MutableLiveData<String>()

    fun setSelectedFilm(filmName: String){
        this.filmName.value = filmName
    }

    var moviesEntity: LiveData<Resource<Film>> = Transformations.switchMap(filmName) { mMovieName ->
        filmRepository.getMovieWithName(mMovieName)
    }

    var tvSeriesEntity: LiveData<Resource<Film>> = Transformations.switchMap(filmName) { mTvSeriesName ->
        filmRepository.getTvSeriesWithName(mTvSeriesName)
    }

    fun setFavoriteMovie() {
        val movieResource = moviesEntity.value
        if (movieResource != null){
            val movie = movieResource.data
            if (movie != null) {
                val newState = !movie.favorited
                filmRepository.setFavoriteMovie(movie, newState)
            }
        }
    }

    fun setFavoriteTvSeries() {
        val tvResponse = tvSeriesEntity.value
        if (tvResponse != null){
            val tvSeries = tvResponse.data
            if (tvSeries != null) {
                val newState = !tvSeries.favorited
                filmRepository.setFavoriteTv(tvSeries, newState)
            }
        }
    }



}