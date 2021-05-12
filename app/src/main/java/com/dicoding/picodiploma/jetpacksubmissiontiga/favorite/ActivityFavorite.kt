package com.dicoding.picodiploma.jetpacksubmissiontiga.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.dicoding.picodiploma.jetpacksubmissiontiga.R
import com.dicoding.picodiploma.jetpacksubmissiontiga.databinding.ActivityFavoriteBinding
import com.dicoding.picodiploma.jetpacksubmissiontiga.main.MainActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ActivityFavorite : AppCompatActivity() {


//    private var menu: Menu? = null

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Tabs
        val sectionPagerAdapterFavorite = SectionPagerAdapterFavorite(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionPagerAdapterFavorite
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager) {
            tab, position -> tab.text = resources.getString(MainActivity.TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Tabs
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