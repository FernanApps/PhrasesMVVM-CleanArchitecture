package practice.phrases.mvvm.domain

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import practice.phrases.data.repository.QuoteRepositoryImp
import practice.phrases.domain.model.Quote

class GetRandomUseCaseTest{
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepositoryImp
    lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase
    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }

    @Test
    fun `when database is empty then return null`() = runBlocking {
       //Give
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()

        //When
        val response = getRandomQuoteUseCase()

        // Then
        assert(response == null)
    }

    @Test
    fun `when database is not empty then return quote`() = runBlocking {
        //Given
        val quoteList = listOf(Quote("Holi", "AristiDevs"))
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns quoteList

        //When
        val response = getRandomQuoteUseCase()

        // Then
        assert(response == quoteList.first())
    }

}