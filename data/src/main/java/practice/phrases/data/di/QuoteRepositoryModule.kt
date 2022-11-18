package practice.phrases.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import practice.phrases.domain.repository.QuoteRepository
import practice.phrases.data.repository.QuoteRepositoryImp


@Module
@InstallIn(ViewModelComponent::class)
abstract class QuoteRepositoryModule {

    @Binds
    abstract fun bindBookRepository(
        quoteRepositoryImp: QuoteRepositoryImp
    ): QuoteRepository

}