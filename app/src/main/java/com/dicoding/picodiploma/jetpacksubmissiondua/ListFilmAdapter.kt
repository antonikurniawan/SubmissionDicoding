package com.dicoding.picodiploma.jetpacksubmissiondua

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.jetpacksubmissiondua.databinding.ItemRowFilmBinding

class ListFilmAdapter: RecyclerView.Adapter<ListFilmAdapter.ListViewHolder>() {

    private val listFilm = ArrayList<Film>()

    fun setListFilms(films: List<Film>){
        if (films == null)
            return this.listFilm.clear()
        this.listFilm.addAll(films)
    }

    inner class ListViewHolder(private val binding: ItemRowFilmBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(film: Film){
            with(binding){
                Glide.with(itemView.context)
                    .load(film.filmImage)
                    .apply(RequestOptions().override(120,150))
                    .into(imgItemFilm)
                txtItemTitle.text = film.filmName

                //click listener
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)

                    intent.putExtra(DetailFilmActivity.EXTRA_DETAIL_FILM, film.filmName)
                    intent.putExtra(DetailFilmActivity.EXTRA_DETAIL_FILM_TYPE, film.filmType)

                    startActivity(itemView.context, intent, null)
//                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowFilmBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listFilm[position])
    }

    override fun getItemCount(): Int = listFilm.size
}