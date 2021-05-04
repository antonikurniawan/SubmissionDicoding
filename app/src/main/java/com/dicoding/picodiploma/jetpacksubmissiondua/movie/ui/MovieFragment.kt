package com.dicoding.picodiploma.jetpacksubmissiondua.movie.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.jetpacksubmissiondua.detail.ListFilmAdapter
import com.dicoding.picodiploma.jetpacksubmissiondua.databinding.FragmentMovieBinding
import com.dicoding.picodiploma.jetpacksubmissiondua.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val filmAdapter = ListFilmAdapter()

            fragmentMovieBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMovies().observe(this, {movie ->
                fragmentMovieBinding.progressBar.visibility = View.GONE
                filmAdapter.setListFilms(movie)
                filmAdapter.notifyDataSetChanged()
            })

            with(fragmentMovieBinding.recycleViewMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = filmAdapter
            }
        }
    }

}