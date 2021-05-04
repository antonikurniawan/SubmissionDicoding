package com.dicoding.picodiploma.jetpacksubmissiondua.di

import android.content.Context
import com.dicoding.picodiploma.jetpacksubmissiondua.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiondua.data.source.remote.RemoteDataSourceFilm
import com.dicoding.picodiploma.jetpacksubmissiondua.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): FilmRepository {

        val remoteDataSourceFilm = RemoteDataSourceFilm.getInstance(JsonHelper(context))

        return FilmRepository.getInstance(remoteDataSourceFilm)
    }
}