package com.dicoding.picodiploma.jetpacksubmissiontiga.favorite.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.jetpacksubmissiontiga.R
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiontiga.databinding.ItemRowFilmBinding
import com.dicoding.picodiploma.jetpacksubmissiontiga.detail.DetailFilmActivity

//class TvFavoriteAdapter: PagedListAdapter<Film, TvFavoriteAdapter.ListViewHolderTvFavorite>(DIFF_CALLBACK) {
//    companion object{
//        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Film>(){
//            override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
//                return oldItem.filmName == newItem.filmName
//            }
//
//            override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//
//    inner class ListViewHolderTvFavorite(private val binding: ItemRowFilmBinding) : RecyclerView.ViewHolder(binding.root){
//        fun bind(film: Film){
//
//            with(binding){
//                Glide.with(itemView.context)
//                        .load(film.filmImage)
//                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
//                        .error(R.drawable.ic_broken_image)
//                        .into(imgItemFilm)
//
//                txtItemTitle.text = film.filmName
//
//
//                //click listener
//                itemView.setOnClickListener{
//                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
//
//                    intent.putExtra(DetailFilmActivity.EXTRA_DETAIL_FILM, film.filmName)
//                    intent.putExtra(DetailFilmActivity.EXTRA_DETAIL_FILM_TYPE, film.filmType)
//
//
//                    ContextCompat.startActivity(itemView.context, intent, null)
//                }
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolderTvFavorite {
//        val binding = ItemRowFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ListViewHolderTvFavorite(binding)
//    }
//
//    override fun onBindViewHolder(holder: ListViewHolderTvFavorite, position: Int) {
//        val film = getItem(position)
//        if (film != null) {
//            holder.bind(film)
//        }
//    }
//}