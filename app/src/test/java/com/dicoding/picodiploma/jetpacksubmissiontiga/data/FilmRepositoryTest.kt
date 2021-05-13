package com.dicoding.picodiploma.jetpacksubmissiontiga.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.LocalDataSource
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.remote.RemoteDataSourceFilm
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.AppExecutors
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.DataDummy
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.LiveDataTestUtil
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.PagedListUtil
import com.dicoding.picodiploma.jetpacksubmissiontiga.vo.Resource


import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer
import org.mockito.Mockito.`when`

class FilmRepositoryTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remoteDataSourceFilm = mock(RemoteDataSourceFilm::class.java)
    private val localDataSource = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val filmRepository = FakeFilmRepository(remoteDataSourceFilm, localDataSource, appExecutors)

    //movie
    private val movieResponse = DataDummy.generateRemoteDummyMovie()
    private val movieTitle = movieResponse[0].title

    //tv series
    private val tvSeriesResponse = DataDummy.generateRemoteDummyTvSeries()
    private val tvSeriesTitle = tvSeriesResponse[0].title


    //Movies Test
    @Test
    fun testGetAllMovies() {

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Film>
        `when`(localDataSource.getAllMovies()).thenReturn(dataSourceFactory)
        filmRepository.getAllMovies()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(localDataSource).getAllMovies()
        assertNotNull(movieEntity.data)
        assertEquals(movieResponse.size.toLong(), movieEntity.data?.size?.toLong())

    }

    @Test
    fun testGetMoviesWithName() {
        val dummyMovie = MutableLiveData<Film>()
        dummyMovie.value = DataDummy.generateSingleDummyMovie()
        `when`<LiveData<Film>>(localDataSource.getMovieByName(movieTitle)).thenReturn(dummyMovie)

        val movieEntity = LiveDataTestUtil.getValue(filmRepository.getMovieWithName(movieTitle))

        verify(localDataSource).getMovieByName(movieTitle)
        assertNotNull(movieEntity)
        assertNotNull(movieEntity.data?.filmName)
        assertNotNull(movieEntity.data?.filmDescription)
        assertNotNull(movieEntity.data?.filmImage)
        assertNotNull(movieEntity.data?.favorited)
        assertNotNull(movieEntity.data?.filmType)

        assertEquals(movieResponse[0].title, movieEntity.data?.filmName)
    }

    //Tv Series Test
    @Test
    fun testGetAllTv() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Film>
        `when`(localDataSource.getAllTvSeries()).thenReturn(dataSourceFactory)
        filmRepository.getAllTv()

        val tvSeriesEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvSeries()))
        verify(localDataSource).getAllTvSeries()
        assertNotNull(tvSeriesEntity.data)
        assertEquals(tvSeriesResponse.size.toLong(), tvSeriesEntity.data?.size?.toLong())

    }

    @Test
    fun testGetTvWithName() {
        val dummyTvSeries = MutableLiveData<Film>()
        dummyTvSeries.value = DataDummy.generateSingleDummyTvSeries()
        `when`<LiveData<Film>>(localDataSource.getTvSeriesByName(tvSeriesTitle)).thenReturn(dummyTvSeries)

        val tvSeriesEntity = LiveDataTestUtil.getValue(filmRepository.getTvSeriesWithName(tvSeriesTitle))

        verify(localDataSource).getTvSeriesByName(tvSeriesTitle)
        assertNotNull(tvSeriesEntity)
        assertNotNull(tvSeriesEntity.data?.filmName)
        assertNotNull(tvSeriesEntity.data?.filmDescription)
        assertNotNull(tvSeriesEntity.data?.filmImage)
        assertNotNull(tvSeriesEntity.data?.favorited)
        assertNotNull(tvSeriesEntity.data?.filmType)

        assertEquals(tvSeriesResponse[0].title, tvSeriesEntity.data?.filmName)

    }

    //Favorite Test
    @Test
    fun testGetFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Film>
        `when`(localDataSource.getFavoriteMovies()).thenReturn(dataSourceFactory)
        filmRepository.getFavoriteMovie()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(localDataSource).getFavoriteMovies()
        assertNotNull(movieEntity)
        assertEquals(movieResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun testGetFavoriteTvSeries() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Film>
        `when`(localDataSource.getFavoriteTvSeries()).thenReturn(dataSourceFactory)
        filmRepository.getFavoriteTvSeries()

        val tvSeriesEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvSeries()))
        verify(localDataSource).getFavoriteTvSeries()
        assertNotNull(tvSeriesEntity)
        assertEquals(tvSeriesResponse.size.toLong(), tvSeriesEntity.data?.size?.toLong())
    }

}