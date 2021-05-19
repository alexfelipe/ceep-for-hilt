package br.com.alura.ceep.ui.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.alura.ceep.database.AppDatabase
import br.com.alura.ceep.repository.NoteRepository
import br.com.alura.ceep.retrofit.RetrofitInit
import br.com.alura.ceep.ui.viewmodel.NoteViewModel

class NoteViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NoteViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(NoteRepository(
                AppDatabase.getInstance(context).getNoteDao(),
                RetrofitInit().getNoteService()
            )) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }

}