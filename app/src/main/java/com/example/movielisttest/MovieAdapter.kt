package com.example.movielisttest

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val dataSet: List<String>): RecyclerView.Adapter<MovieViewHolder>() {
    /**
     * Used to create the ViewHolder
     * This will be called only once
     * If the structure of the ViewHolder changes, this  one will be called again
     * Get @layoutInflater.from(context)
     * Context needs to be from Base context (ContextThemeWrapper)
     * base context provides Themes, Resources an the Inflater
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout,parent,false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        if (position % 2 == 0) holder.itemView.setBackgroundColor(Color.LTGRAY)
        holder.tvMovieTitle.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}