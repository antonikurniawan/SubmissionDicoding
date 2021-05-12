package com.dicoding.picodiploma.jetpacksubmissiontiga.di

import android.content.Context
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.FilmRepository
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.LocalDataSource
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.room.FilmDatabase
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.remote.RemoteDataSourceFilm
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.AppExecutors
import com.dicoding.picodiploma.jetpacksubmissiontiga.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): FilmRepository {

        val database = FilmDatabase.getInstance(context)

        val remoteDataSourceFilm = RemoteDataSourceFilm.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.filmDao())
        val appExecutors = AppExecutors()

        return FilmRepository.getInstance(remoteDataSourceFilm, localDataSource, appExecutors)
    }
}