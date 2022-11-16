package practice.phrases.mvvm.domain

import practice.phrases.mvvm.data.QuoteRepository
import practice.phrases.mvvm.data.model.QuoteModel
import practice.phrases.mvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomUseCase @Inject constructor(
    private val quoteProvider: QuoteProvider
) {
    //private val quoteRepository = QuoteRepository()

    operator fun invoke(): QuoteModel?{
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            return quotes.random()
        }
        return null
    }
}