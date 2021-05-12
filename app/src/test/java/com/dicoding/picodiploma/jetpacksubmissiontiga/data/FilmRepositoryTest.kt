package com.dicoding.picodiploma.jetpacksubmissiontiga.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.remote.RemoteDataSourceFilm
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.DataDummy
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.LiveDataTestUtil


import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer

class FilmRepositoryTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remoteDataSourceFilm = mock(RemoteDataSourceFilm::class.java)
    private val filmRepository = FakeFilmRepository(remoteDataSourceFilm)

    //movie
    private val movieResponse = DataDummy.generateRemoteDummyMovie()
    private val movieTitle = movieResponse[0].title

    //tv series
    private val tvSeriesResponse = DataDummy.generateRemoteDummyTvSeries()
    private val tvSeriesTitle = tvSeriesResponse[0].title

    @Test
    fun testGetAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSourceFilm.LoadMoviesCallback)
                    .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remoteDataSourceFilm).getAllMovies(any())
        val movieEntity = LiveDataTestUtil.getValue(filmRepository.getAllMovies())
        verify(remoteDataSourceFilm).getAllMovies(any())
        assertNotNull(movieEntity)
        assertEquals(movieResponse.size.toLong(), movieEntity.size.toLong())
    }

    @Test
    fun testGetMoviesWithName() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSourceFilm.LoadMoviesCallback)
                    .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remoteDataSourceFilm).getAllMovies(any())

        val movieEntity = LiveDataTestUtil.getValue(filmRepository.getMoviesWithName(movieTitle))

        verify(remoteDataSourceFilm).getAllMovies(any())
        assertNotNull(movieEntity)
        assertNotNull(movieEntity.filmName)
        assertEquals(movieResponse[0].title, movieEntity.filmName)
    }

    @Test
    fun testGetAllTv() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSourceFilm.LoadTvCallback)
                    .onAllTvReceived(tvSeriesResponse)
            null
        }.`when`(remoteDataSourceFilm).getAllTv(any())
        val tvSeriesEntity = LiveDataTestUtil.getValue(filmRepository.getAllTv())
        verify(remoteDataSourceFilm).getAllTv(any())
        assertNotNull(tvSeriesEntity)
        assertEquals(tvSeriesResponse.size.toLong(), tvSeriesEntity.size.toLong())
    }

    @Test
    fun testGetTvWithName() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSourceFilm.LoadTvCallback)
                    .onAllTvReceived(tvSeriesResponse)
            null
        }.`when`(remoteDataSourceFilm).getAllTv(any())

        val tvSeriesEntity = LiveDataTestUtil.getValue(filmRepository.getTvWithName(tvSeriesTitle))

        verify(remoteDataSourceFilm).getAllTv(any())
        assertNotNull(tvSeriesEntity)
        assertNotNull(tvSeriesEntity.filmName)
        assertEquals(tvSeriesResponse[0].title, tvSeriesEntity.filmName)
    }
}