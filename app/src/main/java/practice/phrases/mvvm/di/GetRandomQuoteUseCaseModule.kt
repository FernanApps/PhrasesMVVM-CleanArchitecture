package practice.phrases.mvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import practice.phrases.domain.repository.QuoteRepository
import practice.phrases.domain.usecase.GetRandomQuoteUseCase


@Module
@InstallIn(ViewModelComponent::class)
object GetRandomQuoteUseCaseModuleModule {

    @Provides
    fun provideGetRandomQuoteUseCaseModule(
        quoteRepository: QuoteRepository
    ): GetRandomQuoteUseCase {
        return GetRandomQuoteUseCase(quoteRepository)
    }

}