package practice.phrases.data.datasource.local

import practice.phrases.data.datasource.QuoteDataSource
import practice.phrases.data.datasource.local.database.QuoteDao
import practice.phrases.data.datasource.local.database.QuoteEntity
import javax.inject.Inject

class LocalQuoteDataSource @Inject constructor(
    private val quoteDao: QuoteDao
): QuoteDataSource.Local {
    override suspend fun deleteAllQuotes() {
        quoteDao.deleteAllQuotes()
    }

    override suspend fun getAllQuotes(): List<QuoteEntity> {
        return quoteDao.getAllQuotes()
    }

    override suspend fun insertAll(quotes: List<QuoteEntity>) {
        return quoteDao.insertAll(quotes)
    }
}