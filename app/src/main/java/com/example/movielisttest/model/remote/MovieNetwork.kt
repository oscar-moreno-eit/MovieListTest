package com.example.movielisttest.model.remote

import android.net.Uri
import com.example.movielisttest.model.MovieResponse
import com.example.movielisttest.model.Response
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.logging.Handler

class MovieNetwork {
    //
    companion object{
        const val BASE_URL = "https://gist.githubusercontent.com/"
        const val ENDPOINT = "AntoninoAN/f3fa4b2260c51a5f80904c747009289e/raw/a1403b33a4c0d9a40d1901f6aeba065abc748a38/MovieGist"
        val uriPath = Uri.parse("$BASE_URL$ENDPOINT")
        val url = URL(uriPath.toString())
    }


    fun getMovieList(): Response{
        val httpUrlConnection = url.openConnection() as HttpURLConnection

        httpUrlConnection.readTimeout = 10000
        httpUrlConnection.connectTimeout = 15000
        httpUrlConnection.requestMethod = "GET"
        httpUrlConnection.doInput = true

        httpUrlConnection.connect()

        //httpUrlConnection.responseCode
        //httpUrlConnection.inputStream

        //val response: Response =
            httpUrlConnection.inputStream.run {
            deserializeIS(this)
        }.let {
            return  parseToMovieResponse(it)
        }

    }

    fun  deserializeIS(iS: InputStream): String{
        val builder = StringBuilder()
        val reader = BufferedReader(InputStreamReader(iS))
        var line: String?  = reader.readLine()

        while (line != null){
            builder.append(line)
            builder.append("\n")
            line = reader.readLine()

        }



        if (builder.isEmpty()) return "N/A"
        return builder.toString()
    }

    fun parseToMovieResponse(deserialize: String): Response{
        val response = JSONArray(deserialize)
        val movieResponseList = Response()
        val listOfMovies = mutableListOf<MovieResponse>()
        for(index in 0 until response.length()){// index =  [0,1,2,...response.length}
            val movieElement = response.getJSONObject(index)
            val movieResponse = MovieResponse(rating = movieElement.getDouble("rating").toFloat()
            , image = movieElement.getString("image")
            , title = movieElement.getString("title")
            , releaseYear = movieElement.getInt("releaseYear")
            , genre = movieElement.getJSONArray("genre").parseJsonArrayToList()
            )

            movieResponseList.add(movieResponse)
            listOfMovies.add(movieResponse)
        }
        return movieResponseList
    }

    private fun JSONArray.parseJsonArrayToList(): List<String>{// Extension function
        val result = mutableListOf<String>()
        for  (i in 0 until  this.length()){
            result.add(this.getString(i))
        }
        return result
    }

}