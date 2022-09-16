package com.example.uts_5190411092

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIretrofit {

    val endpoint:APIEndpoint
    get() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.43.159/5190411092_pml/uts/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(APIEndpoint::class.java)

    }
}