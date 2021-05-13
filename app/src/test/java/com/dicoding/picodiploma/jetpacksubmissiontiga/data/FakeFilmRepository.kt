package com.dicoding.picodiploma.jetpacksubmissiontiga.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.LocalDataSource
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.remote.ApiResponse
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.remote.RemoteDataSourceFilm
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.remote.response.MovieResponse
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.remote.response.TvResponse
import com.dicoding.picodiploma.jetpacksubmissiontiga.detail.DetailFilmActivity
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.AppExecutors
import com.dicoding.picodiploma.jetpacksubmissiontiga.vo.Resource


class FakeFilmRepository constructor(
        private val remoteDataSourceFilm: RemoteDataSourceFilm,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors) : FilmDataSource {

    //movie
    override fun getAllMovies(): LiveData<Resource<PagedList<Film>>> {
        return object : NetworkBoundResource<PagedList<Film>, List<MovieResponse>>(appExecutors) {
            public override fun loadFormDB(): LiveData<PagedList<Film>> {
                val config = PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<Film>?): Boolean =
                    data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                    remoteDataSourceFilm.getAllMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<Film>()
                for (response in data) {
                    val movie = Film(
                            response.poster_path,
                            response.title,
                            response.overview,
                            DetailFilmActivity.FILM_TYPE_MOVIE,
                            false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getMovieWithName(movieName: String): LiveData<Resource<Film>> {
        return object : NetworkBoundResource<Film, List<MovieResponse>>(appExecutors){
            override fun loadFormDB(): LiveData<Film> =
                    localDataSource.getMovieByName(movieName)

            override fun shouldFetch(data: Film?): Boolean =
                    data?.filmName == null || data.filmName.isEmpty()


            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                    remoteDataSourceFilm.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                lateinit var movie: Film
                for (response in data){
                    if (response.title == movieName){
                        movie = Film(
                                response.poster_path,
                                response.title,
                                response.overview,
                                DetailFilmActivity.FILM_TYPE_MOVIE,
                                false
                        )
                    }
                }
                localDataSource.insertMoviesByName(movie)
            }

        }.asLiveData()
    }


    //tv series
    override fun getAllTv(): LiveData<Resource<PagedList<Film>>> {
        return object : NetworkBoundResource<PagedList<Film>, List<TvResponse>>(appExecutors) {

            public override fun loadFormDB(): LiveData<PagedList<Film>> {
                val config = PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build()

                return LivePagedListBuilder(localDataSource.getAllTvSeries(), config).build()
            }

            override fun shouldFetch(data: PagedList<Film>?): Boolean =
                    data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                    remoteDataSourceFilm.getAllTv()

            override fun saveCallResult(data: List<TvResponse>) {
                val tvSeriesList = ArrayList<Film>()
                for (response in data) {
                    val tvSeries = Film(
                            response.poster_path,
                            response.title,
                            response.overview,
                            DetailFilmActivity.FILM_TYPE_TV_SERIES,
                            false
                    )
                    tvSeriesList.add(tvSeries)
                }
                localDataSource.insertTvSeries(tvSeriesList)
            }
        }.asLiveData()
    }

    override fun getTvSeriesWithName(tvSeriesName: String): LiveData<Resource<Film>> {
        return object : NetworkBoundResource<Film, List<TvResponse>>(appExecutors){
            override fun loadFormDB(): LiveData<Film> =
                    localDataSource.getTvSeriesByName(tvSeriesName)

            override fun shouldFetch(data: Film?): Boolean =
                    data?.filmName == null || data.filmName.isEmpty()


            override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                    remoteDataSourceFilm.getAllTv()

            override fun saveCallResult(data: List<TvResponse>) {
                lateinit var tvSeries: Film
                for (response in data){
                    if (response.title == tvSeriesName){
                        tvSeries = Film(
                                response.poster_path,
                                response.title,
                                response.overview,
                                DetailFilmActivity.FILM_TYPE_TV_SERIES,
                                false
                        )
                    }
                }
                localDataSource.insertTvSeriesByName(tvSeries)
            }

        }.asLiveData()
    }


    //set favorite
    override fun setFavoriteMovie(movie: Film, state: Boolean) =
            appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

    override fun setFavoriteTv(tvSeries: Film, state: Boolean) =
            appExecutors.diskIO().execute { localDataSource.setTvSeriesFavorite(tvSeries, state)}


    //get favorite list
    override fun getFavoriteMovie(): LiveData<PagedList<Film>> {
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getFavoriteTvSeries(): LiveData<PagedList<Film>> {
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvSeries(), config).build()
    }

//    //movie
//    override fun getAllMovies(): LiveData<List<Film>> {
//        val movieResult = MutableLiveData<List<Film>>()
//        remoteDataSourceFilm.getAllMovies(object : RemoteDataSourceFilm.LoadMoviesCallback{
//            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
//                val movieList = ArrayList<Film>()
//                for (response in movieResponse){
//                    val movie = Film(
//                        response.poster_path,
//                        response.title,
//                        response.overview,
//                        DetailFilmActivity.FILM_TYPE_MOVIE
//                    )
//                    movieList.add(movie)
//                }
//                movieResult.postValue(movieList)
//            }
//        })
//        return movieResult
//    }
//
//    override fun getMoviesWithName(movieName: String): LiveData<Film> {
//        val movieResult = MutableLiveData<Film>()
//
//        remoteDataSourceFilm.getAllMovies(object : RemoteDataSourceFilm.LoadMoviesCallback{
//            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
//                lateinit var movie: Film
//                for (response in movieResponse){
//                    if (response.title == movieName){
//                        movie = Film(
//                                response.poster_path,
//                                response.title,
//                                response.overview,
//                                DetailFilmActivity.FILM_TYPE_MOVIE
//                        )
//                    }
//                }
//                movieResult.postValue(movie)
//            }
//        })
//        return movieResult
//    }
//
//    //tv
//    override fun getAllTv(): LiveData<List<Film>> {
//        val tvResult = MutableLiveData<List<Film>>()
//        remoteDataSourceFilm.getAllTv(object : RemoteDataSourceFilm.LoadTvCallback{
//            override fun onAllTvReceived(tvResponse: List<TvResponse>) {
//                val tvList = ArrayList<Film>()
//                for (response in tvResponse){
//                    val tv = Film(
//                        response.poster_path,
//                        response.title,
//                        response.overview,
//                        DetailFilmActivity.FILM_TYPE_TV_SERIES
//                    )
//                    tvList.add(tv)
//                }
//                tvResult.postValue(tvList)
//            }
//        })
//        return tvResult
//    }
//
//    override fun getTvWithName(tvName: String): LiveData<Film> {
//        val tvResult = MutableLiveData<Film>()
//
//        remoteDataSourceFilm.getAllTv(object : RemoteDataSourceFilm.LoadTvCallback{
//            override fun onAllTvReceived(tvResponse: List<TvResponse>) {
//                lateinit var tv: Film
//                for (response in tvResponse){
//                    if (response.title == tvName){
//                        tv = Film(
//                                response.poster_path,
//                                response.title,
//                                response.overview,
//                                DetailFilmActivity.FILM_TYPE_TV_SERIES
//                        )
//                    }
//                }
//                tvResult.postValue(tv)
//            }
//        })
//        return tvResult
//    }
}