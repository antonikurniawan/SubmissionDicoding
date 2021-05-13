package com.dicoding.picodiploma.jetpacksubmissiontiga.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.dicoding.picodiploma.jetpacksubmissiontiga.R
import com.dicoding.picodiploma.jetpacksubmissiontiga.databinding.ActivityMainBinding
import com.dicoding.picodiploma.jetpacksubmissiontiga.favorite.movie.ActivityFavoriteMovie
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        @StringRes
        val TAB_TITLES = intArrayOf(
                R.string.tab_title_1,
                R.string.tab_title_2
        )
    }

    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Tabs
        val sectionPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager) {
                tab, position -> tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
        //~~~~~~~~~~~Tabs

    }

    //apps bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        this.menu = menu

//        return super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_favorite){
            startActivity(Intent(this, ActivityFavoriteMovie::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
    //==========================
}