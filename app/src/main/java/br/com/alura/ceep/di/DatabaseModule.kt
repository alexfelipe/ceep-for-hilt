package br.com.alura.ceep.di

import android.content.Context
import androidx.room.Room
import br.com.alura.ceep.database.AppDatabase
import br.com.alura.ceep.database.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "ceep.db"

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideNoteDao(db: AppDatabase): NoteDao {
        return db.getNoteDao()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

}