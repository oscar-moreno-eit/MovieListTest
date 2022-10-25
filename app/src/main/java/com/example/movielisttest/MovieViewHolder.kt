package com.example.movielisttest

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    val tvMovieTitle: TextView = view.findViewById(R.id.tv_movie_title)
    val ivImage: ImageView = view.findViewById(R.id.iv_image)
    val tvGenre: TextView = view.findViewById(R.id.tv_genre)
    val tvYear: TextView = view.findViewById(R.id.tv_year)
    val rbRating: RatingBar = view.findViewById(R.id.rb_rating)
    val wgMovieGroup: Group = view.findViewById(R.id.show_details)
    val ibShowDetails: ImageButton = view.findViewById(R.id.ib_showDetails)
}