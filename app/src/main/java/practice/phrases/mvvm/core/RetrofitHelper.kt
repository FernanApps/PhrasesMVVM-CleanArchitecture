package practice.phrases.mvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// https://my-json-server.typicode.com/FernanApps/PhrasesApi/quotes
const val baseUrl = "https://my-json-server.typicode.com"

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}