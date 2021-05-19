package br.com.alura.ceep.retrofit

import br.com.alura.ceep.retrofit.service.NoteService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://cb2ed506-73e8-4d68-84c7-74444c1cf6a0.mock.pstmn.io/"

class RetrofitInit {

    private val retrofit by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }

    fun getNoteService(): NoteService {
        return retrofit.create(NoteService::class.java)
    }

}