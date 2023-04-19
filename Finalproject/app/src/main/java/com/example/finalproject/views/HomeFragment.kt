package com.example.finalproject.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.finalproject.R
import com.example.finalproject.viewmodels.MessageViewModel

@Suppress("DEPRECATION")
class HomeFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val button = view?.findViewById<Button>(R.id.request)
        setSpinnerChoices(view.findViewById(R.id.spinner))

        button?.setOnClickListener {
            val messageInput = view.findViewById<EditText>(R.id.messageInput)
            val message = messageInput?.text.toString()

            val roleInput = view.findViewById<Spinner>(R.id.spinner)
            val role = roleInput?.selectedItem.toString()

            val messageViewModel = MessageViewModel(message, role)
            val bundle = Bundle()
            bundle.putParcelable("response", messageViewModel)

            val nextFragment = DataFragment()
            nextFragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentHost, nextFragment)?.commit()
        }

        return view
    }

    private fun setSpinnerChoices(spinner: Spinner){
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.roles,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
}