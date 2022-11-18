package practice.phrases.data.datasource.remote

import com.google.gson.annotations.SerializedName
import practice.phrases.domain.model.Quote

data class QuoteApi(
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String,
)

