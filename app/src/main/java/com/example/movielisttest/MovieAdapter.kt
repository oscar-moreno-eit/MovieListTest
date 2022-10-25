package com.example.movielisttest

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisttest.model.Response
import com.squareup.picasso.Picasso

class MovieAdapter(private val dataSet: Response): RecyclerView.Adapter<MovieViewHolder>() {
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
        if (position % 2 == 0) holder.itemView.setBackgroundColor(Color.rgb(129,179,223))
        holder.tvMovieTitle.text = dataSet[position].title
        //Picasso.get().load(dataSet[position].image).into(holder.ivImage)
        com.squareup.picasso3.Picasso.Builder(holder.itemView.context).build().load(dataSet[position].image).into(holder.ivImage)
        holder.rbRating.rating = dataSet[position].rating
        holder.tvGenre.text = dataSet[position].genre.toString()
        holder.tvYear.text = dataSet[position].releaseYear.toString()

        holder.ibShowDetails.setOnClickListener {
            holder.wgMovieGroup.visibility = View.VISIBLE
        }

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}