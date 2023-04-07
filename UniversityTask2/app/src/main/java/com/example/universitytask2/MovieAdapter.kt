package com.example.universitytask2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.universitytask2.Models.Movie

class MovieAdapter(
    private val fragment: ProductBarFragment,
    private var movies: ArrayList<Movie>,
    private val listener: Listener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()  {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var textViewTitle : TextView = itemView.findViewById(R.id.movieName)
        var textViewGenre : TextView = itemView.findViewById(R.id.movieGenre)
        var image : ImageView = itemView.findViewById(R.id.movieImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            listener.onClick(position)
        }
        Glide.with(fragment)
            .load(movies[position].image).fitCenter().into(holder.image)
        holder.textViewTitle.text = movies[position].title
        holder.textViewGenre.text = movies[position].genre
    }

    interface Listener {
        fun onClick(itemView: Int)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}