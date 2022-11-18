package practice.phrases.domain.usecase

import practice.phrases.domain.model.Quote
import practice.phrases.domain.repository.QuoteRepository

class GetQuotesUseCase (private val repository: QuoteRepository) {


    suspend operator fun invoke(): List<Quote>{
        val quotes = repository.getAllQuotesFromApi()
        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes)
            quotes
        } else {
            return repository.getAllQuotesFromDatabase()
        }


    }


}