package com.dicoding.picodiploma.jetpacksubmissiontiga.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiontiga.detail.DetailFilmViewModel
import com.dicoding.picodiploma.jetpacksubmissiontiga.di.Injection
import com.dicoding.picodiploma.jetpacksubmissiontiga.favorite.movie.MovieFragmentFavoriteViewModel
import com.dicoding.picodiploma.jetpacksubmissiontiga.favorite.tv.TvSeriesFragmentFavoriteViewModel
import com.dicoding.picodiploma.jetpacksubmissiontiga.movie.ui.MovieViewModel
import com.dicoding.picodiploma.jetpacksubmissiontiga.tv.ui.TvSeriesViewModel

class ViewModelFactory private constructor(private val mFilmRepository: FilmRepository): ViewModelProvider.NewInstanceFactory(){

    companion object{
        @Volatile
        private var instance: ViewModelFactory?= null

        fun getInstance(context: Context): ViewModelFactory = instance?: synchronized(this){
            instance?: ViewModelFactory(Injection.provideRepository(context)).apply {
                instance = this
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        when {

            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mFilmRepository) as T
            }

            modelClass.isAssignableFrom(TvSeriesViewModel::class.java) -> {
                return TvSeriesViewModel(mFilmRepository) as T
            }

            modelClass.isAssignableFrom(DetailFilmViewModel::class.java) ->{
                return DetailFilmViewModel(mFilmRepository) as T
            }

            modelClass.isAssignableFrom(MovieFragmentFavoriteViewModel::class.java) -> {
                return MovieFragmentFavoriteViewModel(mFilmRepository) as T
            }

            modelClass.isAssignableFrom(TvSeriesFragmentFavoriteViewModel::class.java) -> {
                return TvSeriesFragmentFavoriteViewModel(mFilmRepository) as T
            }

            else -> throw Throwable("Unknown Viewmodel Class: " + modelClass.name)
        }
    }
}