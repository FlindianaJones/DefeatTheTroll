package com.example.defeatthetroll.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("feedback/ping")
    fun ping(): Call<String>

    @POST("auth")
    fun auth(@Body credentials: Credentials): Call<AuthResponse>

    @GET("feedback")
    fun feedback(): Call<Array<Feedback>>
}

data class Credentials(val email: String, val password: String)

data class AuthResponse(val token: String, val refreshToken: String)

data class Feedback(val title: String, val body: String, val rating: Int, val posted: String)