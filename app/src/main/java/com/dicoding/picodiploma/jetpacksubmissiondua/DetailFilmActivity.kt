package com.dicoding.picodiploma.jetpacksubmissiondua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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
        setContentView(R.layout.activity_detail_film)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailFilmViewModel::class.java]

        val extra = intent.extras
        if (extra != null){
            val filmName = extra.getString(EXTRA_DETAIL_FILM)
            val filmType = extra.getString(EXTRA_DETAIL_FILM_TYPE)
            if (filmName != null && filmType != null){
                viewModel.setSelectedFilm(filmName, filmType)
                populateFilmData(viewModel.getFilmData())
            }
        }
    }

    private fun populateFilmData(filmEntity: Film){
        Glide.with(this)
                .load(filmEntity.filmImage)
                .apply(RequestOptions().override(120,150))
                .into(img_film_detail)

        txt_film_type.text = filmEntity.filmType
        txt_film_title.text = filmEntity.filmName
        txt_film_description.text = filmEntity.filmDescription
    }
}