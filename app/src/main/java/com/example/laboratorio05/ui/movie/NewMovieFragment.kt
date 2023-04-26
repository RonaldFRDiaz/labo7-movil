package com.example.laboratorio05.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05.R
import com.example.laboratorio05.data.models.MovieModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class NewMovieFragment : Fragment() {

    private val viewModel:  MovieViewModel by activityViewModels {
        MovieViewModel.factory
    }
    private lateinit var name: TextInputEditText
    private lateinit var category: TextInputEditText
    private lateinit var description: TextInputEditText
    private lateinit var calification: TextInputEditText
    private lateinit var actionSumit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind(view)
        actionSumit.set0nclickListener {

        }

    }
    private fun bind(view: View){
        name = view.findViewById(R.id.nameNew)
        category = view.findViewById(R.id.categoryNew)
        description = view.findViewById(R.id.DescriptionNew)
        calification = view.findViewById(R.id.calificationNew)
        actionSumit = view.findViewById(R.id.actionNew)
    }
    private fun createMovie() {
        val newMovie = MovieModel(
            name.text.toString(),
            category.text.toString(),
            description.text.toString(),
            calification.text.toString(),
        )
        viewModel.addMovie(newMovie)

        Log.d("APP TAG", viewModel.getMovies().toString())

        findNavController().popBackStack()
    }

}