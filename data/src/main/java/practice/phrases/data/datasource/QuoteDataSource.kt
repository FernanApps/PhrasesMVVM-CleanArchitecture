package practice.phrases.data.datasource

import practice.phrases.data.datasource.local.database.QuoteEntity
import practice.phrases.data.datasource.remote.QuoteApi
import practice.phrases.domain.util.NetworkResult

interface QuoteDataSource {
    interface Remote {
        suspend fun getQuotes(): NetworkResult<List<QuoteApi>>
    }
    interface Local {
        suspend fun getAllQuotes(): List<QuoteEntity>
        suspend fun insertAll(quotes: List<QuoteEntity>)
        suspend fun deleteAllQuotes()
    }
    //interface Cache : Local
}