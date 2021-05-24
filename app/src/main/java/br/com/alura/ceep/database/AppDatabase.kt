package br.com.alura.ceep.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.alura.ceep.database.dao.NoteDao
import br.com.alura.ceep.model.Note

@Database(
    version = 1,
    exportSchema = false,
    entities = [Note::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

}