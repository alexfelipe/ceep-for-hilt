package br.com.alura.ceep.repository

import br.com.alura.ceep.database.dao.NoteDao
import br.com.alura.ceep.model.Note
import br.com.alura.ceep.retrofit.service.NoteService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NoteRepository(
    private val dao: NoteDao,
    private val service: NoteService
) {

    fun findAll(): Flow<List<Note>> {
        CoroutineScope(IO).launch {
            service.findAll().body()?.let {
                dao.save(it)
            }
        }
        return dao.findAll()
    }

}
