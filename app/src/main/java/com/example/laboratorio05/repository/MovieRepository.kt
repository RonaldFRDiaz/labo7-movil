package com.example.laboratorio05.repositories

import com.example.laboratorio05.data.models.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies

    // add a new movie to the list of movies dummyData.kt
    fun addMovies(movie: MovieModel) = movies.add(movie)


}