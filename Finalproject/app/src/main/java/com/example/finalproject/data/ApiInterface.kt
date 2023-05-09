package com.example.finalproject.data

import com.example.finalproject.BuildConfig
import com.example.finalproject.data.dataModels.AiResponseModel
import com.example.finalproject.data.dataModels.ChatCompletionRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers("Content-Type: application/json",
        "Authorization: Bearer ${BuildConfig.API_KEY}")
    @POST("/v1/chat/completions")
    fun getChatCompletion(@Body request: ChatCompletionRequest): Call<AiResponseModel>
}

