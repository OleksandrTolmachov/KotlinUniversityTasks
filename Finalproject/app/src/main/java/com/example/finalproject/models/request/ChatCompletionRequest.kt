package com.example.finalproject.models.request

data class ChatCompletionRequest(
    val model: String,
    val messages: List<Message>
)