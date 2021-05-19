package br.com.alura.ceep.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.alura.ceep.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(notes: List<Note>)

    @Query("SELECT * FROM Note")
    fun findAll(): Flow<List<Note>>

}