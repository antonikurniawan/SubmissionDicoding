package com.dicoding.picodiploma.jetpacksubmissiontiga.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.jetpacksubmissiontiga.R
import com.dicoding.picodiploma.jetpacksubmissiontiga.databinding.FragmentMovieFavoriteBinding
import com.dicoding.picodiploma.jetpacksubmissiontiga.detail.ListFilmAdapter
import com.dicoding.picodiploma.jetpacksubmissiontiga.viewmodel.ViewModelFactory


class MovieFragmentFavorite : Fragment() {

    private var fragmentMovieFavoriteBinding: FragmentMovieFavoriteBinding? = null
    private val binding get() = fragmentMovieFavoriteBinding



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentMovieFavoriteBinding = FragmentMovieFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieFragmentFavoriteViewModel::class.java]

            val adapter = ListFilmAdapter()
            binding?.progressBar?.visibility = View.VISIBLE

            viewModel.getFavorites().observe(this, { movies ->
                binding?.progressBar?.visibility = View.GONE
                adapter.submitList(movies)
//                adapter.setListFilms(movies)
                adapter.notifyDataSetChanged()
            })

            binding?.recycleViewMovies?.layoutManager = LinearLayoutManager(context)
//            binding?.recycleViewMovies?.setHasFixedSize(true)
            binding?.recycleViewMovies?.adapter = adapter

        }
    }
}