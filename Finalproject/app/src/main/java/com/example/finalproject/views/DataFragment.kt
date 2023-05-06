package com.example.finalproject.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.finalproject.R
import com.example.finalproject.models.repository.AiRepository
import com.example.finalproject.viewmodels.RequestViewModel
import com.example.finalproject.viewmodels.ResponseViewModel

@Suppress("DEPRECATION")
class DataFragment : Fragment() {

    private val aiRepository: AiRepository = AiRepository()
    private val responseViewModel: ResponseViewModel by viewModels()
    private val requestViewModel: RequestViewModel by activityViewModels()

    private lateinit var textLabel: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_data, container, false)
        val button = view.findViewById<Button>(R.id.button)
        textLabel = view.findViewById(R.id.responseContent)

        responseViewModel.getAiResponse(requestViewModel, aiRepository)

        responseViewModel.aiResponse.observe(viewLifecycleOwner) { response ->
            textLabel.text = response
        }

        button?.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentHost, HomeFragment())?.commit()
        }

        return view
    }
}







