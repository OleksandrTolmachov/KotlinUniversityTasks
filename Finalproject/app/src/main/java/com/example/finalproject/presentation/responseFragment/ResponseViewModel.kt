package com.example.finalproject.presentation.responseFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.domain.AIInteractionService
import com.example.finalproject.domain.AIRequest
import kotlinx.coroutines.launch

class ResponseViewModel : ViewModel() {
    private val responseLiveData: MutableLiveData<String> = MutableLiveData()
    private val aiInteractionService: AIInteractionService = AIInteractionService()

    fun getAiResponse(message: String?, role: String?) {
        viewModelScope.launch {
            val response = aiInteractionService.getAIResponse(AIRequest(message, role))
            responseLiveData.postValue(response)
        }
    }

    val aiResponse: LiveData<String>
        get() = responseLiveData
}