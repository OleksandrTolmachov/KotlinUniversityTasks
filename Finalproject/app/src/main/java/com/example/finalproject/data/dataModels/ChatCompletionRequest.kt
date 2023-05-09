package com.example.finalproject.data.dataModels

data class ChatCompletionRequest(
    val model: String,
    val messages: List<Message>
)