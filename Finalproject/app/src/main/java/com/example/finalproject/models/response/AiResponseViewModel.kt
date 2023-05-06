package com.example.finalproject.models.response

import com.example.finalproject.models.request.ChatCompletionChoice
import com.example.finalproject.models.request.ChatCompletionUsage
import com.google.gson.annotations.SerializedName

data class AiResponseViewModel(
    val id: String,
    @SerializedName("object")
    val chatObject: String,
    val created: Long,
    val model: String,
    val usage: ChatCompletionUsage,
    val choices: List<ChatCompletionChoice>,
    @SerializedName("finish_reason")
    val finishReason: String,
    val index: Int
)