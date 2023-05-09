package com.example.finalproject.data

import com.example.finalproject.data.dataModels.AiResponseModel
import com.example.finalproject.data.dataModels.ChatCompletionRequest
import com.example.finalproject.data.dataModels.Message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.openai.com/"
const val AI_CORE_MODEL = "gpt-3.5-turbo"
class AIRepository {
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

    suspend fun getResponse(message: String, role: String): AiResponseModel? = withContext(
        Dispatchers.IO) {
        val request = ChatCompletionRequest(
            model = AI_CORE_MODEL,
            messages = listOf(
                Message(
                    role = role,
                    content = message
                )
            )
        )

        runCatching {
            val response = apiInterface.getChatCompletion(request).execute()
            response.body()
        }.getOrNull()
    }
}