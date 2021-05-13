package com.dicoding.picodiploma.jetpacksubmissiontiga.favorite.tv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.jetpacksubmissiontiga.databinding.ActivityFavoriteTvBinding
import com.dicoding.picodiploma.jetpacksubmissiontiga.detail.ListFilmAdapter
import com.dicoding.picodiploma.jetpacksubmissiontiga.favorite.movie.ActivityFavoriteMovie
import com.dicoding.picodiploma.jetpacksubmissiontiga.viewmodel.ViewModelFactory

class ActivityFavoriteTv : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteTvBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteTvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[TvSeriesFavoriteViewModel::class.java]

        val adapter = ListFilmAdapter()
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getFavorites().observe(this, { tvSeries ->
            binding.progressBar.visibility = View.GONE
//                adapter.currentList?.clear()
            adapter.submitList(tvSeries)
//                adapter.setListFilms(tvSeries)
            adapter.notifyDataSetChanged()
        })

        with(binding.recycleViewTvSeries) {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }

        binding.btnGoToMovieFavoriteList.setOnClickListener {
            val intent = Intent(this, ActivityFavoriteMovie::class.java)
            startActivity(intent)
            finish()
        }

    }
}