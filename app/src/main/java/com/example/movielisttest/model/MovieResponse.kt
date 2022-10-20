package com.example.movielisttest.model

/**
 * In-memory data representation.
 * It provides:
 * toString()
 * hashCode()
 * equals()
 * copy()
 * componentN()
 *
 * Restrictions:
 * It cannot inherited
 * It needs at least 1 field/property
 */


data class MovieResponse(
    val title: String,
    val image: String,
    val rating: Float,
    val releaseYear: Int,
    val genre: List<String>
)

class Response: ArrayList<MovieResponse>()