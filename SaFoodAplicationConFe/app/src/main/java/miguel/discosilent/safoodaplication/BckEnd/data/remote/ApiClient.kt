package miguel.discosilent.safoodaplication.BckEnd.data.remote

import miguel.discosilent.safoodaplication.BckEnd.config.Config
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://yauxlwlieldoshkyjxet.supabase.co/rest/v1/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor) // Interceptor de logging
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("apikey", Config.apiKey)
                .addHeader("Authorization", Config.authToken)
                .addHeader("Content-Type", "application/json")
                .build()
            chain.proceed(request)
        }
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

