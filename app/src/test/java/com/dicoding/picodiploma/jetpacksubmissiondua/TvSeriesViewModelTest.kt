package com.dicoding.picodiploma.jetpacksubmissiondua

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TvSeriesViewModelTest {

    private lateinit var viewModel: TvSeriesViewModel

    @Before
    fun setUp(){
        viewModel = TvSeriesViewModel()
    }

    @Test
    fun testGetTvSeries() {
        val tvSeriesEntities = viewModel.getTvSeries()
        assertNotNull(tvSeriesEntities)
        assertEquals(10, tvSeriesEntities.size)
    }
}