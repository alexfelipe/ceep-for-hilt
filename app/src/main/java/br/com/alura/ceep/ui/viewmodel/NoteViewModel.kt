package br.com.alura.ceep.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.alura.ceep.database.dao.NoteDao
import br.com.alura.ceep.model.Note
import br.com.alura.ceep.repository.NoteRepository
import br.com.alura.ceep.retrofit.service.NoteService
import kotlinx.coroutines.flow.Flow

class NoteViewModel(
    private val repository: NoteRepository
) : ViewModel() {

    fun findAll(): Flow<List<Note>> = repository.findAll()

}