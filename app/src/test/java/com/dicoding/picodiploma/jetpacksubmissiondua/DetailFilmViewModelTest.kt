package com.dicoding.picodiploma.jetpacksubmissiondua

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailFilmViewModelTest {

    private lateinit var viewModelForMovie: DetailFilmViewModel
    private lateinit var viewModelForTvSeries: DetailFilmViewModel


    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieName = dummyMovie.filmName
    private val movieType = dummyMovie.filmType

    private val dummyTvSeries = DataDummy.generateDummyTvSeries()[0]
    private val tvSeriesName = dummyTvSeries.filmName
    private val tvSeriesType = dummyTvSeries.filmType

    @Before
    fun setUp(){
        viewModelForMovie = DetailFilmViewModel()
        viewModelForMovie.setSelectedFilm(movieName, movieType)

        viewModelForTvSeries = DetailFilmViewModel()
        viewModelForTvSeries.setSelectedFilm(tvSeriesName, tvSeriesType)
    }


    @Test
    fun testGetFilmDataIfMovie() {
        viewModelForMovie.setSelectedFilm(dummyMovie.filmName, dummyMovie.filmType)
        val movieEntity = viewModelForMovie.getFilmData()

        assertNotNull(movieEntity)
        assertEquals(dummyMovie.filmName, movieEntity.filmName)
        assertEquals(dummyMovie.filmType, movieEntity.filmType)
        assertEquals(dummyMovie.filmImage, movieEntity.filmImage)
        assertEquals(dummyMovie.filmDescription, movieEntity.filmDescription)
    }

    @Test
    fun testGetFilmDataIfTvSeries() {
        viewModelForTvSeries.setSelectedFilm(dummyTvSeries.filmName, dummyTvSeries.filmType)
        val tvSeriesEntity = viewModelForTvSeries.getFilmData()

        assertNotNull(tvSeriesEntity)
        assertEquals(dummyTvSeries.filmName, tvSeriesEntity.filmName)
        assertEquals(dummyTvSeries.filmType, tvSeriesEntity.filmType)
        assertEquals(dummyTvSeries.filmImage, tvSeriesEntity.filmImage)
        assertEquals(dummyTvSeries.filmDescription, tvSeriesEntity.filmDescription)

    }

    @Test
    fun testGetFilmDataIfNotFound(){
        val emptyViewModel = DetailFilmViewModel()
        emptyViewModel.setSelectedFilm("dummy name", "dummy type")
        val dummyEntity = emptyViewModel.getFilmData()

        //when no data found, get film will return "None" value instead of null
        assertEquals("None", dummyEntity.filmName)
        assertEquals("None", dummyEntity.filmType)
        assertEquals("None", dummyEntity.filmImage)
        assertEquals("None", dummyEntity.filmDescription)
    }
}