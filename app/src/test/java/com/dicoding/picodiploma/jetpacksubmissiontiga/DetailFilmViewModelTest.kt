package com.dicoding.picodiploma.jetpacksubmissiontiga

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiontiga.detail.DetailFilmViewModel
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailFilmViewModelTest {

    //movie
    private lateinit var viewModeForMovie: DetailFilmViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieName = dummyMovie.filmName

    //tv series
    private lateinit var viewModelForTvSeries: DetailFilmViewModel
    private val dummyTv = DataDummy.generateDummyTvSeries()[0]
    private val tvSeriesName = dummyTv.filmName

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var movieObserver: Observer<Film>

    @Mock
    private lateinit var tvSeriesObserver: Observer<Film>


    @Before
    fun setUp(){
        //movie
        viewModeForMovie = DetailFilmViewModel(filmRepository)
        viewModeForMovie.setSelectedFilm(movieName)

        //tv series
        viewModelForTvSeries = DetailFilmViewModel(filmRepository)
        viewModelForTvSeries.setSelectedFilm(tvSeriesName)
    }


    @Test
    fun testGetFilmDataIfMovie() {
        val movie = MutableLiveData<Film>()
        movie.value = dummyMovie

        `when`(filmRepository.getMoviesWithName(movieName)).thenReturn(movie)
        val filmMovie = viewModeForMovie.getMovie().value as Film
        verify(filmRepository).getMoviesWithName(movieName)

        assertNotNull(filmMovie)

        assertEquals(dummyMovie.filmImage, filmMovie.filmImage)
        assertEquals(dummyMovie.filmName, filmMovie.filmName)
        assertEquals(dummyMovie.filmDescription, filmMovie.filmDescription)
        assertEquals(dummyMovie.filmType, filmMovie.filmType)

        viewModeForMovie.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }


    @Test
    fun testGetFilmDataIfTvSeries() {

        val tvSeries = MutableLiveData<Film>()
        tvSeries.value = dummyTv

        `when`(filmRepository.getTvWithName(tvSeriesName)).thenReturn(tvSeries)
        val filmTvSeries = viewModelForTvSeries.getTv().value as Film
        verify(filmRepository).getTvWithName(tvSeriesName)

        assertNotNull(filmTvSeries)

        assertEquals(dummyTv.filmImage, filmTvSeries.filmImage)
        assertEquals(dummyTv.filmName, filmTvSeries.filmName)
        assertEquals(dummyTv.filmDescription, filmTvSeries.filmDescription)
        assertEquals(dummyTv.filmType, filmTvSeries.filmType)

        viewModelForTvSeries.getTv().observeForever(tvSeriesObserver)
        verify(tvSeriesObserver).onChanged(dummyTv)
    }

}