package br.com.alura.ceep.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.alura.ceep.database.dao.NoteDao
import br.com.alura.ceep.model.Note

private const val DATABASE_NAME = "ceep.db"

@Database(
    version = 1,
    exportSchema = false,
    entities = [Note::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {

        private lateinit var db: AppDatabase

        fun getInstance(context: Context): AppDatabase {
            return if (::db.isInitialized) {
                db
            } else {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
        }

    }

}