package practice.phrases.domain.usecase

import practice.phrases.domain.model.Quote
import practice.phrases.domain.repository.QuoteRepository

class GetRandomQuoteUseCase (
    private val repository: QuoteRepository
) {

    suspend operator fun invoke(): Quote?{
        val quotes = repository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()){
            return quotes.random()
        }
        return null
    }
}