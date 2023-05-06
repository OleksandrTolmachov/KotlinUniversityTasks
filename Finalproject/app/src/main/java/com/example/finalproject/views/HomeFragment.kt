package com.example.finalproject.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.finalproject.R
import com.example.finalproject.viewmodels.RequestViewModel

@Suppress("DEPRECATION")
class HomeFragment : Fragment() {
    private val viewModel: RequestViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val button = view.findViewById<Button>(R.id.request)

        setSpinnerChoices(view.findViewById(R.id.spinner))

        button?.setOnClickListener {
            val messageInput = view.findViewById<EditText>(R.id.messageInput)
            val message = messageInput?.text.toString()

            val roleInput = view.findViewById<Spinner>(R.id.spinner)
            val role = roleInput?.selectedItem.toString()

            viewModel.setMessage(message)
            viewModel.setRole(role)

            val nextFragment = DataFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentHost, nextFragment)?.commit()
        }

        return view
    }

    private fun setSpinnerChoices(spinner: Spinner) {
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.roles,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
}