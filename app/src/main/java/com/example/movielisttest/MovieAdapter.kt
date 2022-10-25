package com.example.movielisttest

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisttest.model.Response
import com.squareup.picasso3.Picasso

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
        Picasso.Builder(holder.itemView.context).build().load(dataSet[position].image).into(holder.ivImage)
        holder.rbRating.rating = dataSet[position].rating
        holder.tvGenre.text = dataSet[position].genre.toString()
        holder.tvYear.text = dataSet[position].releaseYear.toString()
        holder.ibShowDetails.setOnClickListener {
            holder.ibShowDetails.background = null

            if (holder.wgMovieGroup.visibility == View.VISIBLE ){
                holder.wgMovieGroup.visibility = View.GONE
                /* Note: You can set a background color and an image resource at the same time but you  cannot set one background color neither a background image at the same time */
                holder.ibShowDetails.setBackgroundColor(Color.LTGRAY)
                holder.ibShowDetails.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            }
            else {
                holder.wgMovieGroup.visibility = View.VISIBLE
                holder.ibShowDetails.setBackgroundColor(Color.LTGRAY)
                holder.ibShowDetails.setImageResource( R.drawable.ic_baseline_keyboard_arrow_up_24)
            }
        }

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}