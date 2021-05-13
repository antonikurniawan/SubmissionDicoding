package com.dicoding.picodiploma.jetpacksubmissiontiga

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiontiga.tv.ui.TvSeriesViewModel
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.DataDummy
import com.dicoding.picodiploma.jetpacksubmissiontiga.vo.Resource
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
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class TvSeriesViewModelTest {

    private lateinit var viewModel: TvSeriesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<Film>>>

    @Before
    fun setUp(){
        viewModel = TvSeriesViewModel(filmRepository)
    }

    @Test
    fun testGetTvSeries() {
//        val dummyTv = DataDummy.generateDummyTvSeries()
//        val tvSeries = MutableLiveData<List<Film>>()
//        tvSeries.value = dummyTv
//
//        `when`(filmRepository.getAllTv()).thenReturn(tvSeries)
//        val film = viewModel.getTvSeries().value
//        verify(filmRepository).getAllTv()
//        assertNotNull(film)
//        assertEquals(10, film?.size)
//
//        viewModel.getTvSeries().observeForever(observer)
//        verify(observer).onChanged(dummyTv)

        val tvSeries = PagedTestDataSources.snapshot(DataDummy.generateDummyTvSeries())
        val expected = MutableLiveData<Resource<PagedList<Film>>>()
        expected.value = Resource.success(tvSeries)

        `when`(filmRepository.getAllTv()).thenReturn(expected)

        viewModel.getTvSeries().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getTvSeries().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.data, actualValue?.data)
        assertEquals(expectedValue?.data?.size, actualValue?.data?.size)
    }

    class PagedTestDataSources private constructor(private val items: List<Film>) : PositionalDataSource<Film>(){

        companion object {
            fun snapshot(items: List<Film> = listOf()): PagedList<Film> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                        .setNotifyExecutor(Executors.newSingleThreadExecutor())
                        .setFetchExecutor(Executors.newSingleThreadExecutor())
                        .build()
            }

        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Film>) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Film>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }





}