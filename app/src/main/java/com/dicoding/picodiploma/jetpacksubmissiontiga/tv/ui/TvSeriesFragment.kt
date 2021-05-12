package com.dicoding.picodiploma.jetpacksubmissiontiga.tv.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.jetpacksubmissiontiga.detail.ListFilmAdapter
import com.dicoding.picodiploma.jetpacksubmissiontiga.databinding.FragmentTvSeriesBinding
import com.dicoding.picodiploma.jetpacksubmissiontiga.viewmodel.ViewModelFactory
import com.dicoding.picodiploma.jetpacksubmissiontiga.vo.Status


class TvSeriesFragment : Fragment() {

    private var fragmentTvSeriesBinding: FragmentTvSeriesBinding? = null
    private val binding get() = fragmentTvSeriesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentTvSeriesBinding = FragmentTvSeriesBinding.inflate(layoutInflater, container, false)
        return fragmentTvSeriesBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvSeriesViewModel::class.java]

            val filmAdapter = ListFilmAdapter()

            viewModel.getTvSeries().observe(this, { tv ->
                if (tv != null) {
                    when(tv.status) {
                        Status.LOADING -> {
                            binding?.progressBar?.visibility = View.VISIBLE
                        }

                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            filmAdapter.submitList(tv.data)
                            filmAdapter.notifyDataSetChanged()
                        }

                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi Kesalahan dalam TV Series Fragment", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentTvSeriesBinding?.recycleViewTvSeries) {
                this?.layoutManager = LinearLayoutManager(context)
//                this?.setHasFixedSize(true)
                this?.adapter = filmAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentTvSeriesBinding = null
    }

}