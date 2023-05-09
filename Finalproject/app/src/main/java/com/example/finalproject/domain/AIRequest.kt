package com.example.finalproject.domain

class AIRequest(private val message: String?, private val role: String?) {
    val messageValue: String?
        get() = message

    val roleValue: String?
        get() = role
}