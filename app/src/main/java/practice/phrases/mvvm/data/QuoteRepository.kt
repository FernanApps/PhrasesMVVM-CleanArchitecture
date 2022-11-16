package practice.phrases.mvvm.data

import com.google.gson.annotations.SerializedName
import practice.phrases.mvvm.data.database.dao.QuoteDao
import practice.phrases.mvvm.data.database.entities.QuoteEntity
import practice.phrases.mvvm.data.network.QuoteService
import practice.phrases.mvvm.domain.model.Quote
import practice.phrases.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao

    ) {

    suspend fun getAllQuotesFromApi():List<Quote>{
        val response = api.getQuotes()
        return response.map { quoteModel ->
            quoteModel.toDomain()
        }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { quoteEntity ->
            quoteEntity.toDomain()
        }
    }

    suspend fun insertQuotes(quote : List<QuoteEntity>){
        return quoteDao.insertAll(quote)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }

}