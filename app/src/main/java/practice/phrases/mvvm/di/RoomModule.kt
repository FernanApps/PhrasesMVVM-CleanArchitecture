package practice.phrases.mvvm.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import practice.phrases.mvvm.data.database.QuoteDatabase
import practice.phrases.mvvm.data.database.dao.QuoteDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val QUOTE_DATABASE_NAME = "quote_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext contex: Context): QuoteDatabase {
        return Room.databaseBuilder(contex, QuoteDatabase::class.java, QUOTE_DATABASE_NAME).build()
    }

    @Singleton
    @Provides
    fun provideQuoteDao(db: QuoteDatabase) = db.getQuoteDao()

}