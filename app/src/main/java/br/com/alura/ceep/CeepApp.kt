package br.com.alura.ceep

import android.app.Application
import br.com.alura.ceep.database.AppDatabase
import br.com.alura.ceep.model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CeepApp : Application() {

    override fun onCreate() {
        super.onCreate()

//        saveNotes(
//            listOf(
//                Note(
//                    title = "first title",
//                    description = "first description"
//                ),
//                Note(
//                    title = "second title",
//                    description = "second description"
//                )
//            )
//        )
    }

    private fun saveNotes(notes: List<Note>) {
        CoroutineScope(IO).launch {
            AppDatabase.getInstance(this@CeepApp)
                .getNoteDao().save(notes)
        }
    }

}