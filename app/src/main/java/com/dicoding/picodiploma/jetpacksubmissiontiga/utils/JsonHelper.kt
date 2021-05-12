package com.dicoding.picodiploma.jetpacksubmissiontiga.utils

import android.content.Context
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.remote.response.MovieResponse
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.remote.response.TvResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`. available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException){
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieList.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()){
                val result = listArray.getJSONObject(i)

                val id = result.getString("id")
                val title = result.getString("title")
                val overview = result.getString("overview")
                val posterPath = result.getString("poster_path")

                val movieResponse = MovieResponse(id, title, overview, posterPath)
                list.add(movieResponse)
            }
        } catch (ex: JSONException){
            ex.printStackTrace()
        }
        return list
    }

    fun loadTv(): List<TvResponse> {
        val list = ArrayList<TvResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvList.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()){
                val result = listArray.getJSONObject(i)

                val id = result.getString("id")
                val title = result.getString("title")
                val overview = result.getString("overview")
                val posterPath = result.getString("poster_path")

                val tvResponse = TvResponse(id, title, overview, posterPath)
                list.add(tvResponse)
            }
        } catch (ex: JSONException){
            ex.printStackTrace()
        }
        return list
    }

}