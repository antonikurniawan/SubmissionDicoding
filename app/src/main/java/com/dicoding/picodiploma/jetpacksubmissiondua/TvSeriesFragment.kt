package com.dicoding.picodiploma.jetpacksubmissiondua

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tv_series.*


class TvSeriesFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_series, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvSeriesViewModel::class.java]
            val tvSeries = viewModel.getTvSeries()

            val filmAdapter = ListFilmAdapter()
            filmAdapter.setListFilms(tvSeries)

            recycle_view_tv_series.layoutManager = LinearLayoutManager(context)
            recycle_view_tv_series.setHasFixedSize(true)
            recycle_view_tv_series.adapter = filmAdapter
        }
    }
}