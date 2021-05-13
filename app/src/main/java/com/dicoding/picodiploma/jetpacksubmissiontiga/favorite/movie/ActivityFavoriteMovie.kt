package com.dicoding.picodiploma.jetpacksubmissiontiga.favorite.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.jetpacksubmissiontiga.databinding.ActivityFavoriteMovieBinding
import com.dicoding.picodiploma.jetpacksubmissiontiga.detail.ListFilmAdapter
import com.dicoding.picodiploma.jetpacksubmissiontiga.favorite.tv.ActivityFavoriteTv
import com.dicoding.picodiploma.jetpacksubmissiontiga.viewmodel.ViewModelFactory

class ActivityFavoriteMovie : AppCompatActivity() {


//    private var menu: Menu? = null

    private lateinit var binding: ActivityFavoriteMovieBinding

//    private var activityFavoriteBinding: ActivityFavoriteBinding ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Tabs
//        val sectionPagerAdapterFavorite = SectionPagerAdapterFavorite(this)
//        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
//        viewPager.adapter = sectionPagerAdapterFavorite
//        val tabs: TabLayout = findViewById(R.id.tabs)
//        TabLayoutMediator(tabs, viewPager) {
//            tab, position -> tab.text = resources.getString(MainActivity.TAB_TITLES[position])
//        }.attach()
//
//        supportActionBar?.elevation = 0f
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Tabs

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[MovieFavoriteViewModel::class.java]


        val adapter = ListFilmAdapter()
        binding.progressBar.visibility = View.VISIBLE

        viewModel.getFavorites().observe(this, { movies ->
            binding.progressBar.visibility = View.GONE
//                adapter.currentList?.clear()
            adapter.submitList(movies)
//                adapter.setListFilms(movies)
            adapter.notifyDataSetChanged()
        })

        with(binding.recycleViewMovies) {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }

        binding.btnGoToTvFavoriteList.setOnClickListener {
            val intent = Intent(this, ActivityFavoriteTv::class.java)
            startActivity(intent)
            finish()
        }

    }

//    //apps menu bar
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//        this.menu = menu
//
////        return super.onCreateOptionsMenu(menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return super.onOptionsItemSelected(item)
//    }
//    //=================
}