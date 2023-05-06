package com.example.finalproject.viewmodels

import androidx.lifecycle.ViewModel

class RequestViewModel : ViewModel() {
    private var message: String = ""
    private var role: String = ""

    fun setMessage(message: String) {
        this.message = message
    }

    fun setRole(role: String) {
        this.role = role
    }


    val messageValue: String
        get() = message

    val roleValue: String
        get() = role
}