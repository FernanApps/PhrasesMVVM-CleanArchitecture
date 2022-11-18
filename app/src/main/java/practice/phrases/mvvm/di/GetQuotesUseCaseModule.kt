package practice.phrases.mvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import practice.phrases.domain.repository.QuoteRepository
import practice.phrases.domain.usecase.GetQuotesUseCase

@Module
@InstallIn(ViewModelComponent::class)
object GetQuotesUseCaseModule {

    @Provides
    fun provideGetQuotesUseCase(
        quoteRepository: QuoteRepository
    ): GetQuotesUseCase {
        return GetQuotesUseCase(quoteRepository)
    }

}
