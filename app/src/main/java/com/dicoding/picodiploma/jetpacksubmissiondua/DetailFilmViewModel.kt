package com.dicoding.picodiploma.jetpacksubmissiondua

import androidx.lifecycle.ViewModel

class DetailFilmViewModel: ViewModel() {
    private lateinit var filmName: String
    private lateinit var filmType: String

    fun setSelectedFilm(filmName: String, filmType: String){
        this.filmName = filmName
        this.filmType = filmType
    }

    fun getFilmData(): Film {
        lateinit var film: Film

        //if movie
        if (filmType == DetailFilmActivity.FILM_TYPE_MOVIE){
            val movieData = DataDummy.generateDummyMovie()
            for (filmData in movieData){
                if (filmData.filmName == filmName){
                    film = filmData
                    return film
                }
            }
        }

        //if tv series
        if (filmType == DetailFilmActivity.FILM_TYPE_TV_SERIES){
            val tvSeriesData = DataDummy.generateDummyTvSeries()
            for (filmData in tvSeriesData){
                if (filmData.filmName == filmName){
                    film = filmData
                    return film
                }
            }
        }

        //if none/not found
        return Film("None", "None", "None", "None")
    }

}