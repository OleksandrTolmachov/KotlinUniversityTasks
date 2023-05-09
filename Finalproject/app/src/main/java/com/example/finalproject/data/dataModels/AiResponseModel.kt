package com.example.finalproject.data.dataModels

import com.google.gson.annotations.SerializedName

data class AiResponseModel(
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