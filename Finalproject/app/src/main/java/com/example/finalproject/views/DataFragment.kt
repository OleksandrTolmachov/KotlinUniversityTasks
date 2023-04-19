package com.example.finalproject.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.finalproject.R
import com.example.finalproject.models.repository.AiRepository
import com.example.finalproject.viewmodels.MessageViewModel

@Suppress("DEPRECATION")
class DataFragment : Fragment() {

    private val aiRepository: AiRepository = AiRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_data, container, false)
        val button = view?.findViewById<Button>(R.id.button)
        val textLabel = view.findViewById<TextView>(R.id.responseContent)

        val message = this.arguments?.getParcelable("response", MessageViewModel::class.java)
        if (message != null) {
            getAiResponse(message) { response ->
                textLabel.setText(response)
            }
        }
        button?.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentHost, HomeFragment())?.commit()
        }

        return view
    }

    private fun getAiResponse(message: MessageViewModel, callback: (String?) -> Unit) {
        aiRepository.getResponse(message) { chatCompletionResponse ->
            if (chatCompletionResponse != null && chatCompletionResponse.choices.isNotEmpty()) {
                val response = chatCompletionResponse.choices[0].message.content
                callback(response)
            } else {
                callback("No response received")
            }
        }
    }
}
