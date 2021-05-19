package br.com.alura.ceep.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.ceep.model.Note
import br.com.alura.ceep.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteViewModel(
    private val repository: NoteRepository
) : ViewModel() {

    fun findAll(): Flow<List<Note>> = repository.findAll()

}