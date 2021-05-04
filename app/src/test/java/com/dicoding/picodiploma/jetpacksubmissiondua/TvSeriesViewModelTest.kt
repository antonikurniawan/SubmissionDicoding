package com.dicoding.picodiploma.jetpacksubmissiondua

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.picodiploma.jetpacksubmissiondua.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiondua.tv.ui.TvSeriesViewModel
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
class TvSeriesViewModelTest {

    private lateinit var viewModel: TvSeriesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<Film>>

    @Before
    fun setUp(){
        viewModel = TvSeriesViewModel(filmRepository)
    }

    @Test
    fun testGetTvSeries() {
        val dummyTv = DataDummy.generateDummyTvSeries()
        val tvSeries = MutableLiveData<List<Film>>()
        tvSeries.value = dummyTv

        `when`(filmRepository.getAllTv()).thenReturn(tvSeries)
        val film = viewModel.getTvSeries().value
        verify(filmRepository).getAllTv()
        assertNotNull(film)
        assertEquals(10, film?.size)

        viewModel.getTvSeries().observeForever(observer)
        verify(observer).onChanged(dummyTv)

    }
}