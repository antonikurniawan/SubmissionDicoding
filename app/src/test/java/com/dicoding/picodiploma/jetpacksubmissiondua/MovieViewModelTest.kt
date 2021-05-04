package com.dicoding.picodiploma.jetpacksubmissiondua

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.picodiploma.jetpacksubmissiondua.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiondua.movie.ui.MovieViewModel
import com.dicoding.picodiploma.jetpacksubmissiondua.utils.DataDummy
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
class MovieViewModelTest{

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<Film>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(filmRepository)
    }

    @Test
    fun testGetMovies() {
        val dummyMovie = DataDummy.generateDummyMovie()
        val movie = MutableLiveData<List<Film>>()
        movie.value = dummyMovie

        `when`(filmRepository.getAllMovies()).thenReturn(movie)
        val film = viewModel.getMovies().value
        verify(filmRepository).getAllMovies()
        assertNotNull(film)
        assertEquals(10, film?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)

    }
}