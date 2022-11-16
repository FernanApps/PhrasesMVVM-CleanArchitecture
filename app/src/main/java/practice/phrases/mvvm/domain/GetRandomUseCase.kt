package practice.phrases.mvvm.domain

import practice.phrases.mvvm.data.QuoteRepository
import practice.phrases.mvvm.data.model.QuoteModel
import practice.phrases.mvvm.data.model.QuoteProvider

class GetRandomUseCase {
    //private val quoteRepository = QuoteRepository()

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            return quotes.random()
        }
        return null
    }
}