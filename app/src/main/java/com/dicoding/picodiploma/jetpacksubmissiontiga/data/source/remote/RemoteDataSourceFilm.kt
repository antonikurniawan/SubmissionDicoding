package com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.remote.response.MovieResponse
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.remote.response.TvResponse
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.EspressoIdlingResource
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.JsonHelper

//class RemoteDataSourceFilm private constructor(private val jsonHelper: JsonHelper) {
//
//    companion object{
//
//        private const val SERVICE_LATENCY_IN_MILLIES: Long = 2000
//
//        @Volatile
//        private var instance: RemoteDataSourceFilm? = null
//
//        fun getInstance(helper: JsonHelper): RemoteDataSourceFilm = instance ?: synchronized(this){
//            RemoteDataSourceFilm(helper).apply {
//                instance = this
//            }
//        }
//    }
//
//    private val handler = Handler(Looper.getMainLooper())
//
//    //movie
//    fun getAllMovies(callback: LoadMoviesCallback) {
//        EspressoIdlingResource.increment()
//        handler.postDelayed({
//            callback.onAllMoviesReceived(jsonHelper.loadMovie())
//            EspressoIdlingResource.decrement()
//        }, SERVICE_LATENCY_IN_MILLIES)
//    }
//
//    interface LoadMoviesCallback {
//        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
//    }
//
//    //tv
//    fun getAllTv(callback: LoadTvCallback){
//        EspressoIdlingResource.increment()
//        handler.postDelayed({
//            callback.onAllTvReceived(jsonHelper.loadTv())
//            EspressoIdlingResource.decrement()
//        }, SERVICE_LATENCY_IN_MILLIES)
//    }
//
//    interface LoadTvCallback {
//        fun onAllTvReceived(tvResponse: List<TvResponse>)
//    }
//
//}

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
    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovie())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIES)
        return resultMovie
    }

//    fun getMoviesByName(movieName: String): LiveData<ApiResponse<MovieResponse>> {
//        EspressoIdlingResource.increment()
//        val resultMovie = MutableLiveData<ApiResponse<MovieResponse>>()
//
//    }


    //tv
    fun getAllTv(): LiveData<ApiResponse<List<TvResponse>>>{
        EspressoIdlingResource.increment()
        val resultTvSeries = MutableLiveData<ApiResponse<List<TvResponse>>>()
        handler.postDelayed({
            resultTvSeries.value = ApiResponse.success(jsonHelper.loadTv())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIES)
        return resultTvSeries
    }



}