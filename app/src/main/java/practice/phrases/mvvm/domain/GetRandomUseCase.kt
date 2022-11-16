package practice.phrases.mvvm.domain

import practice.phrases.mvvm.data.QuoteRepository
import practice.phrases.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomUseCase @Inject constructor(
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