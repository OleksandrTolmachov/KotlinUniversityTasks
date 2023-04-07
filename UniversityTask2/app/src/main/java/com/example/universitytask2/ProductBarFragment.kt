package com.example.universitytask2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.universitytask2.Models.Movie
import com.example.universitytask2.databinding.FragmentContentBinding
import com.example.universitytask2.databinding.FragmentProductBarBinding

class ProductBarFragment : Fragment(), MovieAdapter.Listener {

    private var _binding: FragmentProductBarBinding? = null
    private val binding get() = _binding!!

    var movies = ArrayList<Movie>()
    lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var firstMovie = Movie(
            getString(R.string.Title1),
            getString(R.string.Genre1),
            getString(R.string.Description1),
            getString(R.string.Image1)
        )
        var secondMovie = Movie(
            getString(R.string.Title2),
            getString(R.string.Genre2),
            getString(R.string.Description2),
            getString(R.string.Image2)
        )
        var thirdMovie = Movie(
            getString(R.string.Title3),
            getString(R.string.Genre3),
            getString(R.string.Description3),
            getString(R.string.Image3)
        )

        movies.add(firstMovie)
        movies.add(secondMovie)
        movies.add(thirdMovie)
        adapter = MovieAdapter(this, movies, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductBarBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)

        binding.RecyclerView.layoutManager = layoutManager
        binding.RecyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(itemView: Int) {
        val bundle = bundleOf(
            ContentFragment.numberInArray to itemView,
            ContentFragment.title to movies[itemView].title,
            ContentFragment.genre to movies[itemView].genre,
            ContentFragment.description to movies[itemView].shortDescription,
            ContentFragment.urlImage to movies[itemView].image
        )
        findNavController().navigate(R.id.action_productBarFragment_to_contentFragment, bundle)
    }
}