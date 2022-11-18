package practice.phrases.data.mapper

import practice.phrases.data.datasource.local.database.QuoteEntity
import practice.phrases.data.datasource.remote.QuoteApi
import practice.phrases.domain.model.Quote

object Mappers {
    fun Quote.toDatabase() = QuoteEntity(quote = quote, author = author)
    fun QuoteEntity.toDomain() = Quote(quote, author)
    fun QuoteApi.toDomain() = Quote(quote, author)

}