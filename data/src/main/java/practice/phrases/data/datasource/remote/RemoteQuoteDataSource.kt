package practice.phrases.data.datasource.remote

import practice.phrases.data.datasource.QuoteDataSource
import practice.phrases.domain.util.NetworkResult
import javax.inject.Inject

class RemoteQuoteDataSource @Inject constructor(
    private val apiService: QuoteService
): QuoteDataSource.Remote {
    override suspend fun getQuotes(): NetworkResult<List<QuoteApi>> {
        return apiService.getQuotes()
    }
}