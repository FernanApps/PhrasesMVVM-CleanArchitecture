package practice.phrases.mvvm.domain

import practice.phrases.mvvm.data.QuoteRepository
import practice.phrases.mvvm.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>?{
        return repository.getAllQuotes()
    }

}