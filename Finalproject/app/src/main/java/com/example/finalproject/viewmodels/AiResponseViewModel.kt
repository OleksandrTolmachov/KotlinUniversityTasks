package com.example.finalproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.models.repository.AiRepository

class ResponseViewModel : ViewModel() {
    private val responseLiveData: MutableLiveData<String> = MutableLiveData()

    fun getAiResponse(message: RequestViewModel, repository: AiRepository) {

        repository.getResponse(message) { chatCompletionResponse ->
            val response = if (chatCompletionResponse != null && chatCompletionResponse.choices.isNotEmpty()) {
                chatCompletionResponse.choices[0].message.content
            } else {
                "No response received"
            }
            responseLiveData.postValue(response)
        }
    }

    val aiResponse: LiveData<String>
        get() = responseLiveData
}