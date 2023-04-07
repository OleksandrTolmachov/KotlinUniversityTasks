package com.example.universitytask2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.universitytask2.databinding.FragmentContentBinding

class ContentFragment : Fragment() {

    private var _binding : FragmentContentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view).load(arguments?.getString(urlImage)).fitCenter().into(binding.imageView)
        binding.movieTitle.text = arguments?.getString(title)
        binding.genreValue.text = arguments?.getString(genre)
        binding.movieDescription.text = arguments?.getString(description)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        const val numberInArray = "number"
        const val title = "movie"
        const val genre = "genre"
        const val description = "desc"
        const val urlImage = "url"
    }
}