package com.dicoding.picodiploma.jetpacksubmissiontiga.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dicoding.picodiploma.jetpacksubmissiontiga.movie.ui.MovieFragment
import com.dicoding.picodiploma.jetpacksubmissiontiga.tv.ui.TvSeriesFragment

class SectionsPagerAdapter (activity: AppCompatActivity) : FragmentStateAdapter(activity){

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position){
            0 -> fragment = MovieFragment()
            1 -> fragment = TvSeriesFragment()
        }
        return fragment as Fragment
    }

}