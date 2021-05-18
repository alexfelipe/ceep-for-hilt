package br.com.alura.ceep.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.ceep.database.dao.NoteDao

class NoteViewModel(private val dao: NoteDao) : ViewModel() {

    fun findAll() = dao.findAll()

}