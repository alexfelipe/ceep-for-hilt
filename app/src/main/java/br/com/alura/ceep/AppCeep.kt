package br.com.alura.ceep

import android.app.Application
import br.com.alura.ceep.database.dao.NoteDao
import br.com.alura.ceep.model.Note
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class CeepApp : Application() {

    @Inject lateinit var dao: NoteDao

    override fun onCreate() {
        super.onCreate()

        saveNotes(
            listOf(
                Note(
                    title = "first title",
                    description = "first description"
                ),
                Note(
                    title = "second title",
                    description = "second description"
                )
            )
        )
    }

    private fun saveNotes(notes: List<Note>) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.save(notes)
        }
    }

}