package com.dicoding.picodiploma.jetpacksubmissiontiga.movie.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.jetpacksubmissiontiga.detail.ListFilmAdapter
import com.dicoding.picodiploma.jetpacksubmissiontiga.databinding.FragmentMovieBinding
import com.dicoding.picodiploma.jetpacksubmissiontiga.viewmodel.ViewModelFactory
import com.dicoding.picodiploma.jetpacksubmissiontiga.vo.Status

//class MovieFragment : Fragment() {
//
//    private lateinit var fragmentMovieBinding: FragmentMovieBinding
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
//        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
//        return fragmentMovieBinding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        if (activity != null){
//
//            val factory = ViewModelFactory.getInstance(requireActivity())
//            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
//
//            val filmAdapter = ListFilmAdapter()
//
//            fragmentMovieBinding.progressBar.visibility = View.VISIBLE
//            viewModel.getMovies().observe(this, {movie ->
//                fragmentMovieBinding.progressBar.visibility = View.GONE
//                filmAdapter.setListFilms(movie)
//                filmAdapter.notifyDataSetChanged()
//            })
//
//            with(fragmentMovieBinding.recycleViewMovies) {
//                layoutManager = LinearLayoutManager(context)
//                setHasFixedSize(true)
//                adapter = filmAdapter
//            }
//        }
//    }
//
//}

class MovieFragment : Fragment() {

    private var fragmentMovieBinding: FragmentMovieBinding? = null
    private val binding get() = fragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val filmAdapter = ListFilmAdapter()

            viewModel.getMovies().observe(this, {movie ->
                if (movie != null){
                    when (movie.status){
                        Status.LOADING -> {
                            binding?.progressBar?.visibility = View.VISIBLE
                        }
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            filmAdapter.submitList(movie.data)
                            filmAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan dalam Movie Fragment", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentMovieBinding?.recycleViewMovies) {
                this?.layoutManager = LinearLayoutManager(context)
//                this?.setHasFixedSize(true)
                this?.adapter = filmAdapter
//                this?.adapter?.notifyDataSetChanged()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentMovieBinding = null
    }

}