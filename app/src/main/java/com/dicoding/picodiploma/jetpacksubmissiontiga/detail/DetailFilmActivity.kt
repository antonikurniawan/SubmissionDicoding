package com.dicoding.picodiploma.jetpacksubmissiontiga.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.jetpacksubmissiontiga.R
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiontiga.databinding.ActivityDetailFilmBinding
import com.dicoding.picodiploma.jetpacksubmissiontiga.viewmodel.ViewModelFactory
import com.dicoding.picodiploma.jetpacksubmissiontiga.vo.Status
import kotlinx.android.synthetic.main.activity_detail_film.*

//class DetailFilmActivity : AppCompatActivity() {
//
//    companion object{
//        const val EXTRA_DETAIL_FILM = "extra_detail_film"
//        const val EXTRA_DETAIL_FILM_TYPE = "extra_detail_film_type"
//
//        const val FILM_TYPE_TV_SERIES = "Tv Series"
//        const val FILM_TYPE_MOVIE = "Movies"
//    }
//
//    private var menu: Menu? = null
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
//
//        setContentView(activityDetailFilmBinding.root)
//
//
//        val factory = ViewModelFactory.getInstance(this)
//        val viewModel = ViewModelProvider(this, factory)[DetailFilmViewModel::class.java]
//
//        val extra = intent.extras
//        if (extra != null){
//            val filmName = extra.getString(EXTRA_DETAIL_FILM)
//            val filmType = extra.getString(EXTRA_DETAIL_FILM_TYPE)
//            if (filmName != null && filmType != null){
//
//                activityDetailFilmBinding.progressBar.visibility = View.VISIBLE
//
//                viewModel.setSelectedFilm(filmName)
//
//
//                //if movie
//                if (filmType.equals(FILM_TYPE_MOVIE)){
//                    viewModel.getMovie().observe( this, {movie ->
//                        populateFilmData(movie)
//                        activityDetailFilmBinding.progressBar.visibility = View.GONE
//                    })
//                }
//                //if tv
//                else {
//                    viewModel.getTv().observe(this, {tv ->
//                        populateFilmData(tv)
//                        activityDetailFilmBinding.progressBar.visibility = View.GONE
//                    })
//
//                }
//            }
//        }
//    }
//
//    private fun populateFilmData(filmEntity: Film){
//        Glide.with(this)
//                .load(filmEntity.filmImage)
//                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).override(120,150))
//                .error(R.drawable.ic_broken_image)
//                .into(img_film_detail)
//
//        txt_film_type.text = filmEntity.filmType
//        txt_film_title.text = filmEntity.filmName
//        txt_film_description.text = filmEntity.filmDescription
//    }
//
//    //apps menu bar
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//        this.menu = menu
//
////        return super.onCreateOptionsMenu(menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return super.onOptionsItemSelected(item)
//    }
//    //=================
//}

class DetailFilmActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DETAIL_FILM = "extra_detail_film"
        const val EXTRA_DETAIL_FILM_TYPE = "extra_detail_film_type"
//        const val EXTRA_FILM_LIST_SIZE = "extra_film_list_size"
//        const val EXTRA_FILM_POSITION = "extra_film_position"

        const val FILM_TYPE_TV_SERIES = "Tv Series"
        const val FILM_TYPE_MOVIE = "Movies"

    }

    private lateinit var activityDetailFilmBinding: ActivityDetailFilmBinding

    private lateinit var viewModel: DetailFilmViewModel
    private var menu: Menu? = null

    private lateinit var filmType: String
    private var filmName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)

        setContentView(activityDetailFilmBinding.root)


        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailFilmViewModel::class.java]

        val extra = intent.extras
        if (extra != null){
            filmName = extra.getString(EXTRA_DETAIL_FILM)
            filmType = extra.getString(EXTRA_DETAIL_FILM_TYPE).toString()
            if (filmName != null && filmType != null){

                viewModel.setSelectedFilm(filmName!!)

                //if movie
                if (filmType.equals(FILM_TYPE_MOVIE)){
                    viewModel.moviesEntity.observe( this, {movie ->
                        if (movie != null) {
                            when (movie.status) {
                                Status.LOADING ->{
                                    activityDetailFilmBinding.progressBar.visibility = View.VISIBLE
                                }

                                Status.SUCCESS -> {
                                    populateFilmData(movie.data)
                                    activityDetailFilmBinding.progressBar.visibility = View.GONE
                                }

                                Status.ERROR -> {
                                    activityDetailFilmBinding.progressBar.visibility = View.GONE
                                    Toast.makeText(applicationContext, "Terjadi Kesalahan Movies", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    })
                }

                //if tv
                else {
                    viewModel.tvSeriesEntity.observe(this, { tvSeries ->
                        if (tvSeries != null) {
                            when (tvSeries.status) {
                                Status.LOADING -> {
                                    activityDetailFilmBinding.progressBar.visibility = View.VISIBLE
                                }

                                Status.SUCCESS -> {
                                    populateFilmData(tvSeries.data)
                                    activityDetailFilmBinding.progressBar.visibility = View.GONE
                                }

                                Status.ERROR -> {
                                    activityDetailFilmBinding.progressBar.visibility = View.VISIBLE
                                    Toast.makeText(applicationContext, "Terjadi Kesalahan dalam Tv Series", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    })
                }


            }


        }

        //test position
//        setButtonNextPreviousState()
//
//        activityDetailFilmBinding.btnPrevious.setOnClickListener {
//            viewModel
//        }
//        activityDetailFilmBinding.btnNext.setOnClickListener {
//            viewModel
//        }

    }

    private fun populateFilmData(filmEntity: Film?){
        Glide.with(this)
            .load(filmEntity?.filmImage)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).override(120,150))
            .error(R.drawable.ic_broken_image)
            .into(img_film_detail)

        txt_film_type.text = filmEntity?.filmType
        txt_film_title.text = filmEntity?.filmName
        txt_film_description.text = filmEntity?.filmDescription

    }

    //apps menu bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        this.menu = menu

        //movie
        if (filmType.equals(FILM_TYPE_MOVIE)){
            viewModel.moviesEntity.observe(this, { movie ->
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> {
                            activityDetailFilmBinding.progressBar.visibility = View.VISIBLE
                        }
                        Status.SUCCESS -> {
                            if (movie.data != null) {
                                activityDetailFilmBinding.progressBar.visibility = View.GONE
                                val state = movie.data.favorited
                                setFavoriteState(state)
                            }
                        }
                        Status.ERROR -> {
                            activityDetailFilmBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi Kesalahan dalam onCreateOptionsMenu Movie!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }

        //tv
        else {
            viewModel.tvSeriesEntity.observe( this, { tvSeries ->
                if (tvSeries != null) {
                    when (tvSeries.status) {
                        Status.LOADING -> {
                            activityDetailFilmBinding.progressBar.visibility = View.VISIBLE
                        }
                        Status.SUCCESS -> {
                            if (tvSeries.data != null) {
                                activityDetailFilmBinding.progressBar.visibility = View.GONE
                                val state = tvSeries.data.favorited
                                setFavoriteState(state)
                            }
                        }
                        Status.ERROR -> {
                            activityDetailFilmBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi Kesalahan dalam onCreateOptionsMenu Movie!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_favorite) {
            if (filmType.equals(FILM_TYPE_MOVIE)){
                viewModel.setFavoriteMovie()
            }
            else {
                viewModel.setFavoriteTvSeries()
            }
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean){
        if (menu == null) {
            Toast.makeText(this, "Error cannot change favorite state: Menu is null!", Toast.LENGTH_SHORT).show()
            return
        }
        val menuItem = menu?.findItem(R.id.menu_favorite)
        if (state){
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_unfavorite)
        }
    }

    //=================

//    private fun setButtonNextPreviousState(){
//        //get position
//        var sizeList = intent.extras?.getString(EXTRA_FILM_LIST_SIZE)?.toInt()
//        var position = intent.extras?.getString(EXTRA_FILM_POSITION)?.toInt()
//
//        if (position != null && sizeList != null) {
//            activityDetailFilmBinding.btnNext.isEnabled = false
//            activityDetailFilmBinding.btnPrevious.isEnabled = false
//
//            if (position < (sizeList - 1)){
//                activityDetailFilmBinding.btnNext.isEnabled = true
//            }
//            if (position > 0){
//                activityDetailFilmBinding.btnPrevious.isEnabled = true
//            }
//        }
//
//        //Example if list size is 1, and choose 1, output would be:
//        //position = 0, size list = 1
//        //case: if list size is 10, and choose 3, output would be:
//        //position = 2, size list = 10
//        //position will be start from 0 (index)
//        println("code 100: Position is: "+ position + " while current list film size is: "+sizeList)
//    }

}