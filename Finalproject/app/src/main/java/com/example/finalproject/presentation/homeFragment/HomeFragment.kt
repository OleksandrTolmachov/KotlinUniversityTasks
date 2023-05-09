package com.example.finalproject.presentation.homeFragment

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
import com.example.finalproject.presentation.responseFragment.DataFragment

@Suppress("DEPRECATION")
class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val button = view.findViewById<Button>(R.id.request)

        setSpinnerChoices(view.findViewById(R.id.spinner))

        button?.setOnClickListener {

            val bundle = Bundle()
            val messageInput = view.findViewById<EditText>(R.id.messageInput)
            bundle.putString("message", messageInput?.text.toString())

            val roleInput = view.findViewById<Spinner>(R.id.spinner)
            bundle.putString("role", roleInput?.selectedItem.toString())

            val destinationFragment = DataFragment()
            destinationFragment.arguments = bundle

            parentFragmentManager.beginTransaction().replace(R.id.fragmentHost, destinationFragment)
                .addToBackStack(null)
                .commit()
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