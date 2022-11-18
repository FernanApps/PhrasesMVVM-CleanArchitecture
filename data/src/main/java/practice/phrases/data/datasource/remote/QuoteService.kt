package practice.phrases.data.datasource.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import practice.phrases.domain.util.NetworkResult
import retrofit2.HttpException
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val apiClient: QuoteApiClient,
) {

    suspend fun getQuotes(): NetworkResult<List<QuoteApi>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiClient.getAllQuotes()

                if(response.isSuccessful && response.body() != null){
                    NetworkResult.Success(response.body()!!)
                } else {
                    NetworkResult.Failure(code = response.code(), message = response.message())
                }

                //response.body() ?: emptyList()

            } catch (e: HttpException){
                NetworkResult.Failure(code = e.code(), message = e.message())
            }
            catch (e: Exception){
                NetworkResult.Exception(e)
            }
        }

    }
}