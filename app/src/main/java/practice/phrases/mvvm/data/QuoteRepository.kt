package practice.phrases.mvvm.data

import practice.phrases.mvvm.data.model.QuoteModel
import practice.phrases.mvvm.data.model.QuoteProvider
import practice.phrases.mvvm.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}