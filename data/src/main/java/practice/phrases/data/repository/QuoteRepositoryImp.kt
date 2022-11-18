package practice.phrases.data.repository

import android.util.Log
import practice.phrases.data.datasource.QuoteDataSource
import practice.phrases.domain.model.Quote
import practice.phrases.domain.repository.QuoteRepository
import practice.phrases.data.mapper.Mappers.toDatabase
import practice.phrases.data.mapper.Mappers.toDomain
import practice.phrases.domain.util.NetworkResult

import javax.inject.Inject
import kotlin.text.Typography.quote

const val TAG = "QuoteRepositoryImp"
class QuoteRepositoryImp @Inject constructor(
    private val local: QuoteDataSource.Local,
    private val remote: QuoteDataSource.Remote,
    //private val cache: QuoteDataSource.Cache
    ): QuoteRepository {


    override suspend fun getAllQuotesFromApi(): List<Quote>{
        return when(val response = remote.getQuotes()){
            is NetworkResult.Exception -> {
                Log.e(TAG, "Exception :: message : ${response.e.message}")
                response.e.printStackTrace()
                emptyList<Quote>()
            }
            is NetworkResult.Failure -> {
                Log.e(TAG, "Failure :: message : ${response.message} - code: ${response.code}")
                emptyList<Quote>()
            }
            is NetworkResult.Success -> response.data.map { quoteModel ->
                quoteModel.toDomain()
            }
        }
    }

    override suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = local.getAllQuotes()
        return response.map { quoteEntity ->
            quoteEntity.toDomain()
        }
    }

    override suspend fun insertQuotes(quote : List<Quote>){
        return local.insertAll(quote.map {
            it.toDatabase()
        })
    }

    override suspend fun clearQuotes() {
        local.deleteAllQuotes()
    }


}