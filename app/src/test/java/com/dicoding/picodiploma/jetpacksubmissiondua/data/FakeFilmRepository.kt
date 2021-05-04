package com.dicoding.picodiploma.jetpacksubmissiondua.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.remote.RemoteDataSourceFilm
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.remote.response.MovieResponse
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.remote.response.TvResponse
import com.dicoding.picodiploma.jetpacksubmissiondua.detail.DetailFilmActivity


class FakeFilmRepository(private val remoteDataSourceFilm: RemoteDataSourceFilm) : FilmDataSource {

    //movie
    override fun getAllMovies(): LiveData<List<Film>> {
        val movieResult = MutableLiveData<List<Film>>()
        remoteDataSourceFilm.getAllMovies(object : RemoteDataSourceFilm.LoadMoviesCallback{
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<Film>()
                for (response in movieResponse){
                    val movie = Film(
                        response.poster_path,
                        response.title,
                        response.overview,
                        DetailFilmActivity.FILM_TYPE_MOVIE
                    )
                    movieList.add(movie)
                }
                movieResult.postValue(movieList)
            }
        })
        return movieResult
    }

    override fun getMoviesWithName(movieName: String): LiveData<Film> {
        val movieResult = MutableLiveData<Film>()

        remoteDataSourceFilm.getAllMovies(object : RemoteDataSourceFilm.LoadMoviesCallback{
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                lateinit var movie: Film
                for (response in movieResponse){
                    if (response.title == movieName){
                        movie = Film(
                                response.poster_path,
                                response.title,
                                response.overview,
                                DetailFilmActivity.FILM_TYPE_MOVIE
                        )
                    }
                }
                movieResult.postValue(movie)
            }
        })
        return movieResult
    }

    //tv
    override fun getAllTv(): LiveData<List<Film>> {
        val tvResult = MutableLiveData<List<Film>>()
        remoteDataSourceFilm.getAllTv(object : RemoteDataSourceFilm.LoadTvCallback{
            override fun onAllTvReceived(tvResponse: List<TvResponse>) {
                val tvList = ArrayList<Film>()
                for (response in tvResponse){
                    val tv = Film(
                        response.poster_path,
                        response.title,
                        response.overview,
                        DetailFilmActivity.FILM_TYPE_TV_SERIES
                    )
                    tvList.add(tv)
                }
                tvResult.postValue(tvList)
            }
        })
        return tvResult
    }

    override fun getTvWithName(tvName: String): LiveData<Film> {
        val tvResult = MutableLiveData<Film>()

        remoteDataSourceFilm.getAllTv(object : RemoteDataSourceFilm.LoadTvCallback{
            override fun onAllTvReceived(tvResponse: List<TvResponse>) {
                lateinit var tv: Film
                for (response in tvResponse){
                    if (response.title == tvName){
                        tv = Film(
                                response.poster_path,
                                response.title,
                                response.overview,
                                DetailFilmActivity.FILM_TYPE_TV_SERIES
                        )
                    }
                }
                tvResult.postValue(tv)
            }
        })
        return tvResult
    }
}