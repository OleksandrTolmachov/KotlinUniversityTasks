package com.example.finalproject.models.repository

import com.example.finalproject.models.request.ApiInterface
import com.example.finalproject.models.request.ChatCompletionRequest
import com.example.finalproject.viewmodels.AiResponseViewModel
import com.example.finalproject.models.request.Message
import com.example.finalproject.viewmodels.MessageViewModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.openai.com/"
const val AI_CORE_MODEL = "gpt-3.5-turbo"
class AiRepository {
    private val apiInterface: ApiInterface

    init {
        val client = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()

        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getResponse(message: MessageViewModel, callback: (AiResponseViewModel?) -> Unit) {
        val request = ChatCompletionRequest(
            model = AI_CORE_MODEL,
            messages = listOf(Message(role = message.role, content = message.message))
        )

        apiInterface.getChatCompletion(request).enqueue(object : Callback<AiResponseViewModel> {
            override fun onResponse(call: Call<AiResponseViewModel>, response: Response<AiResponseViewModel>) {
                val chatCompletionResponse = response.body()
                callback(chatCompletionResponse)
            }

            override fun onFailure(call: Call<AiResponseViewModel>, t: Throwable) {
                callback(null)
            }
        })
    }
}