package com.example.finalproject.domain

import com.example.finalproject.data.AIRepository

//use cases
class AIInteractionService {
    private val aiRepository = AIRepository()

    suspend fun getAIResponse(request: AIRequest) : String
    {
        if(request.messageValue == null || request.roleValue == null)
            return "Wrong entered request."

        val response = aiRepository.getResponse(request.messageValue!!, request.roleValue!!)
        return response?.choices?.get(0)?.message?.content ?: "No response received"
    }
}