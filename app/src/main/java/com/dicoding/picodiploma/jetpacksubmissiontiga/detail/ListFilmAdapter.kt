package com.dicoding.picodiploma.jetpacksubmissiontiga.detail

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
//import com.dicoding.picodiploma.jetpacksubmissiondua.databinding.ItemRowFilmBinding
import com.dicoding.picodiploma.jetpacksubmissiontiga.R
import com.dicoding.picodiploma.jetpacksubmissiontiga.data.source.local.entity.Film
import com.dicoding.picodiploma.jetpacksubmissiontiga.databinding.ItemRowFilmBinding

//class ListFilmAdapter: RecyclerView.Adapter<ListFilmAdapter.ListViewHolder>() {
//
//    private val listFilm = ArrayList<Film>()
//
//
//    fun setListFilms(films: List<Film>?){
//        if (films == null)
//            return this.listFilm.clear()
//
//        this.listFilm.clear()
//
//        this.listFilm.addAll(films)
//
//        this.notifyDataSetChanged()
//    }
//
//    inner class ListViewHolder(private val binding: ItemRowFilmBinding) : RecyclerView.ViewHolder(binding.root){
//        fun bind(film: Film){
//
//            with(binding){
//                Glide.with(itemView.context)
//                    .load(film.filmImage)
//                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
//                    .error(R.drawable.ic_broken_image)
//                    .into(imgItemFilm)
//
//                txtItemTitle.text = film.filmName
//
//                bindingAdapterPosition
//
//                //click listener
//                itemView.setOnClickListener{
//                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)
//
//                    intent.putExtra(DetailFilmActivity.EXTRA_DETAIL_FILM, film.filmName)
//                    intent.putExtra(DetailFilmActivity.EXTRA_DETAIL_FILM_TYPE, film.filmType)
//
////                    //get list size and film selected position
////                    intent.putExtra(DetailFilmActivity.EXTRA_FILM_LIST_SIZE, listFilm.size.toString())
////                    intent.putExtra(DetailFilmActivity.EXTRA_FILM_POSITION, bindingAdapterPosition.toString())
//
//                    startActivity(itemView.context, intent, null)
//                }
//            }
//        }
//    }
//
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
//        val binding = ItemRowFilmBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
//        return ListViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        holder.bind(listFilm[position])
//    }
//
//    override fun getItemCount(): Int = listFilm.size
//
//}

//pagging
class ListFilmAdapter: PagedListAdapter<Film, ListFilmAdapter.ListViewHolder>(DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Film>(){
            override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
                return oldItem.filmName == newItem.filmName
            }

            override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun submitList(pagedList: PagedList<Film>?) {
        super.submitList(pagedList)
        this.notifyDataSetChanged()
    }
//    private val listFilm = ArrayList<Film>()


//    fun setListFilms(films: List<Film>?){
//        if (films == null)
//            return this.listFilm.clear()
//
//        this.listFilm.clear()
//
//        this.listFilm.addAll(films)
//
//        this.notifyDataSetChanged()
//    }

    inner class ListViewHolder(private val binding: ItemRowFilmBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(film: Film){

            with(binding){
                Glide.with(itemView.context)
                    .load(film.filmImage)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_broken_image)
                    .into(imgItemFilm)

                txtItemTitle.text = film.filmName

//                bindingAdapterPosition

                //click listener
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailFilmActivity::class.java)

                    intent.putExtra(DetailFilmActivity.EXTRA_DETAIL_FILM, film.filmName)
                    intent.putExtra(DetailFilmActivity.EXTRA_DETAIL_FILM_TYPE, film.filmType)

//                    //get list size and film selected position
//                    intent.putExtra(DetailFilmActivity.EXTRA_FILM_LIST_SIZE, listFilm.size.toString())
//                    intent.putExtra(DetailFilmActivity.EXTRA_FILM_POSITION, bindingAdapterPosition.toString())

                    startActivity(itemView.context, intent, null)
                }
            }
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowFilmBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val film = getItem(position)
        if (film != null) {
            holder.bind(film)
        }
    }

//    override fun getItemCount(): Int = listFilm.size

}