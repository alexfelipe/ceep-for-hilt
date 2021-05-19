package br.com.alura.ceep.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import java.util.*

@Entity
data class Note(
    @PrimaryKey
    val id: Int = 0,
    val title: String = "",
    val description: String = ""
)
