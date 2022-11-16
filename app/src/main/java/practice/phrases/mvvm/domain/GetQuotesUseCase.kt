package practice.phrases.mvvm.domain

import practice.phrases.mvvm.data.QuoteRepository
import practice.phrases.mvvm.data.database.entities.toDatabase
import practice.phrases.mvvm.data.model.QuoteModel
import practice.phrases.mvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {


    suspend operator fun invoke(): List<Quote>{
        val quotes = repository.getAllQuotesFromApi()
        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map {
                it.toDatabase()
            })
            quotes
        } else {
            return repository.getAllQuotesFromDatabase()
        }


    }


}