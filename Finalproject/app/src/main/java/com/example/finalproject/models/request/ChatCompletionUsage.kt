package com.example.finalproject.models.request

import com.google.gson.annotations.SerializedName

data class ChatCompletionUsage(
    @SerializedName("prompt_tokens")
    val promptTokens: Int,
    @SerializedName("completion_tokens")
    val completionTokens: Int,
    @SerializedName("total_tokens")
    val totalTokens: Int
)