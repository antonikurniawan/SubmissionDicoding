package com.dicoding.picodiploma.jetpacksubmissiondua.tv.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.jetpacksubmissiondua.detail.ListFilmAdapter
import com.dicoding.picodiploma.jetpacksubmissiondua.databinding.FragmentTvSeriesBinding
import com.dicoding.picodiploma.jetpacksubmissiondua.viewmodel.ViewModelFactory


class TvSeriesFragment : Fragment() {

    private lateinit var fragmentTvSeriesBinding: FragmentTvSeriesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentTvSeriesBinding = FragmentTvSeriesBinding.inflate(layoutInflater, container, false)
        return fragmentTvSeriesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvSeriesViewModel::class.java]

            val filmAdapter = ListFilmAdapter()

            fragmentTvSeriesBinding.progressBar.visibility = View.VISIBLE

            viewModel.getTvSeries().observe(this, { tv ->
                fragmentTvSeriesBinding.progressBar.visibility = View.GONE
                filmAdapter.setListFilms(tv)
                filmAdapter.notifyDataSetChanged()
            })

            with(fragmentTvSeriesBinding.recycleViewTvSeries) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = filmAdapter
            }
        }
    }

}