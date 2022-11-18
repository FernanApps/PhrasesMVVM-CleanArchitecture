package practice.phrases.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import practice.phrases.data.datasource.QuoteDataSource
import practice.phrases.data.datasource.local.LocalQuoteDataSource
import practice.phrases.data.datasource.remote.RemoteQuoteDataSource

@Module
@InstallIn(ViewModelComponent::class)
abstract class QuoteDataSourceModule {

    @Binds
    abstract fun bindQuoteLocalDataSource(
        local: LocalQuoteDataSource
    ): QuoteDataSource.Local

    @Binds
    abstract fun bindQuoteRemoteDataSource(
        local: RemoteQuoteDataSource
    ): QuoteDataSource.Remote

}