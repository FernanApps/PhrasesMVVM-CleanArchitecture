package practice.phrases.mvvm.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import practice.phrases.mvvm.core.RetrofitHelper
import practice.phrases.mvvm.data.model.QuoteModel
import javax.inject.Inject

class QuoteService @Inject constructor(private val apiClient: QuoteApiClient){

    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response =  apiClient.getAllQuotes()
            response.body() ?: emptyList()
        }

    }
}