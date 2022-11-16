package practice.phrases.mvvm.domain.model

import com.google.gson.annotations.SerializedName
import practice.phrases.mvvm.data.database.entities.QuoteEntity
import practice.phrases.mvvm.data.model.QuoteModel

data class Quote(
    val quote: String,
    val author: String,
)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)