package practice.phrases.mvvm.data.network

import practice.phrases.mvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

// https://my-json-server.typicode.com/FernanApps/PhrasesApi/quotes
interface QuoteApiClient {

    @GET("/FernanApps/PhrasesApi/quotes")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>

}