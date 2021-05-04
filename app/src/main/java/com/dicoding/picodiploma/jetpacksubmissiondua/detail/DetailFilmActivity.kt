package com.dicoding.picodiploma.jetpacksubmissiondua.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.jetpacksubmissiondua.R
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiondua.databinding.ActivityDetailFilmBinding
import com.dicoding.picodiploma.jetpacksubmissiondua.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_film.*

class DetailFilmActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DETAIL_FILM = "extra_detail_film"
        const val EXTRA_DETAIL_FILM_TYPE = "extra_detail_film_type"

        const val FILM_TYPE_TV_SERIES = "Tv Series"
        const val FILM_TYPE_MOVIE = "Movies"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)

        setContentView(activityDetailFilmBinding.root)


        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailFilmViewModel::class.java]

        val extra = intent.extras
        if (extra != null){
            val filmName = extra.getString(EXTRA_DETAIL_FILM)
            val filmType = extra.getString(EXTRA_DETAIL_FILM_TYPE)
            if (filmName != null && filmType != null){

                activityDetailFilmBinding.progressBar.visibility = View.VISIBLE

                viewModel.setSelectedFilm(filmName)


                //if movie
                if (filmType.equals(FILM_TYPE_MOVIE)){
                    viewModel.getMovie().observe( this, {movie ->
                        populateFilmData(movie)
                        activityDetailFilmBinding.progressBar.visibility = View.GONE
                    })
                }
                //if tv
                else {
                    viewModel.getTv().observe(this, {tv ->
                        populateFilmData(tv)
                        activityDetailFilmBinding.progressBar.visibility = View.GONE
                    })

                }
            }
        }
    }

    private fun populateFilmData(filmEntity: Film){
        Glide.with(this)
                .load(filmEntity.filmImage)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).override(120,150))
                .error(R.drawable.ic_broken_image)
                .into(img_film_detail)

        txt_film_type.text = filmEntity.filmType
        txt_film_title.text = filmEntity.filmName
        txt_film_description.text = filmEntity.filmDescription
    }
}