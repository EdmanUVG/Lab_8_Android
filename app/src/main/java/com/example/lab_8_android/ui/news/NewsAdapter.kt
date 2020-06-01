package com.example.lab_8_android.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_8_android.R
import com.example.lab_8_android.database.Result

class NewsAdapter(val results: List<Result>): RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item_layout, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        return holder.bind(results[position])
    }
}

class NewsViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    private val photo: ImageView = itemView.findViewById(R.id.movie_photo)
    private val title: TextView = itemView.findViewById(R.id.movie_title)
    private val overview:TextView = itemView.findViewById(R.id.movie_overview)
    private val rating:TextView = itemView.findViewById(R.id.movie_rating)

    fun bind(aNew: Result) {
        Glide.with(itemView.context).load("http://image.tmdb.org/t/p/w500${aNew.poster_path}").into(photo)
        title.text = "Title: "+aNew.title
        overview.text = aNew.overview
        rating.text = "Rating : "+aNew.vote_average.toString()
    }

}