package br.com.alura.ceep.retrofit.service

import br.com.alura.ceep.model.Note
import retrofit2.Response
import retrofit2.http.GET

interface NoteService {

    @GET("notes")
    suspend fun findAll(): Response<List<Note>>

}