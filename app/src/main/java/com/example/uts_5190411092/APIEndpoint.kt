package com.example.uts_5190411092

import retrofit2.Call
import retrofit2.http.GET

interface APIEndpoint {
    @GET("tampildata.php")
    fun data() : Call<Model>
}