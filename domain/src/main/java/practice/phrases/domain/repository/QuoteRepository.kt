package practice.phrases.domain.repository


import practice.phrases.domain.model.Quote

interface QuoteRepository {

    suspend fun getAllQuotesFromApi():List<Quote>

    suspend fun getAllQuotesFromDatabase(): List<Quote>

    suspend fun insertQuotes(quote : List<Quote>)

    suspend fun clearQuotes()

}