package com.dicoding.picodiploma.jetpacksubmissiondua.data.source.remote

import android.os.Handler
import android.os.Looper
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.remote.response.MovieResponse
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.remote.response.TvResponse
import com.dicoding.picodiploma.jetpacksubmissiondua.utils.EspressoIdlingResource
import com.dicoding.picodiploma.jetpacksubmissiondua.utils.JsonHelper

class RemoteDataSourceFilm private constructor(private val jsonHelper: JsonHelper) {

    companion object{

        private const val SERVICE_LATENCY_IN_MILLIES: Long = 2000

        @Volatile
        private var instance: RemoteDataSourceFilm? = null

        fun getInstance(helper: JsonHelper): RemoteDataSourceFilm = instance ?: synchronized(this){
            RemoteDataSourceFilm(helper).apply {
                instance = this
            }
        }
    }

    private val handler = Handler(Looper.getMainLooper())

    //movie
    fun getAllMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovie())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIES)
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

    //tv
    fun getAllTv(callback: LoadTvCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllTvReceived(jsonHelper.loadTv())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIES)
    }

    interface LoadTvCallback {
        fun onAllTvReceived(tvResponse: List<TvResponse>)
    }

}