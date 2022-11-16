package practice.phrases.mvvm.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import practice.phrases.mvvm.core.RetrofitHelper
import practice.phrases.mvvm.data.model.QuoteModel

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response =  retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }

    }
}