package com.example.finalproject.presentation.responseFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.presentation.homeFragment.HomeFragment

@Suppress("DEPRECATION")
class DataFragment : Fragment() {
    private val responseViewModel: ResponseViewModel by viewModels()

    private lateinit var textLabel: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_data, container, false)
        val bundle = arguments
        val button = view.findViewById<Button>(R.id.button)
        textLabel = view.findViewById(R.id.responseContent)

        responseViewModel.getAiResponse(bundle?.getString("message"),
            bundle?.getString("role"))
        responseViewModel.aiResponse.observe(viewLifecycleOwner) { response ->
            textLabel.text = response
        }

        button?.setOnClickListener {
            val nextFragment = HomeFragment()
            parentFragmentManager.beginTransaction().replace(R.id.fragmentHost, nextFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}







