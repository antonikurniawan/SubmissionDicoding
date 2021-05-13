package com.dicoding.picodiploma.jetpacksubmissiontiga.favorite.tv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.jetpacksubmissiontiga.databinding.FragmentTvSeriesFavoriteBinding
import com.dicoding.picodiploma.jetpacksubmissiontiga.detail.ListFilmAdapter
import com.dicoding.picodiploma.jetpacksubmissiontiga.viewmodel.ViewModelFactory


//class TvSeriesFragmentFavorite : Fragment() {
//
//    private var fragmentTvSeriesFavoriteBinding: FragmentTvSeriesFavoriteBinding? = null
//    private val binding get() = fragmentTvSeriesFavoriteBinding
//
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
//        fragmentTvSeriesFavoriteBinding = FragmentTvSeriesFavoriteBinding.inflate(inflater, container, false)
//        return binding?.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        if (activity != null) {
//            val factory = ViewModelFactory.getInstance(requireActivity())
//            val viewModel = ViewModelProvider(this, factory)[TvSeriesFavoriteViewModel::class.java]
//
//            val adapter = ListFilmAdapter()
//            binding?.progressBar?.visibility = View.VISIBLE
//            viewModel.getFavorites().observe(this, { tvSeries ->
//                binding?.progressBar?.visibility = View.GONE
////                adapter.currentList?.clear()
//                adapter.submitList(tvSeries)
////                adapter.setListFilms(tvSeries)
//                adapter.notifyDataSetChanged()
//            })
//
//            with(binding?.recycleViewTvSeries) {
//                this?.layoutManager = LinearLayoutManager(context)
//                this?.adapter = adapter
//            }
//
////            binding?.recycleViewTvSeries?.layoutManager = LinearLayoutManager(context)
//////            binding?.recycleViewTvSeries?.setHasFixedSize(true)
////            binding?.recycleViewTvSeries?.adapter = adapter
//        }
//    }
//
//}