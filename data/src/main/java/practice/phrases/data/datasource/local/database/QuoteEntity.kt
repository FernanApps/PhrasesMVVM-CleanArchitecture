package practice.phrases.data.datasource.local.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote_table")
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "id") val id: Int = 0,
    @ColumnInfo (name = "quote") val quote: String,
    @ColumnInfo (name = "author") val author: String,
)

