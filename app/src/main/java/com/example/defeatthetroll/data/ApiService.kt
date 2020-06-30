package com.example.defeatthetroll.data

import com.example.defeatthetroll.MainActivity
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("feedback/ping")
    fun ping(): Call<String>

    @POST("auth")
    fun auth(@Body credentials: Credentials): Call<AuthResponse>

    @GET("feedback")
    fun feedback(): Call<Array<Feedback>>

    @POST("feedback")
    fun feedback(@Body feedback: Feedback): Call<CreatedResponse>

    @POST("feedback/doot")
    fun doot(@Body doot: DootRequest): Call<String>

    @FormUrlEncoded
    @POST("handler.php")
    fun grant(@FieldMap service_request: Map<String, String>): Call<GrantResponse>
}

data class GrantRequest(val user: Int, val service: String, val action: String, val session_key: String)

data class GrantResponse(val user: Int, val session_key: String)

data class CreatedResponse(val id: String)

data class Credentials(val email: String, val password: String)

data class AuthResponse(val accessToken: String, val refreshToken: String)

data class User(val firstName: String, val lastName: String)

data class Feedback(val title: String, val content: String, val rating: Int = 1, val created: String = "", val poster: User = User("", ""), val _id: String = "")

data class DootRequest(val id: String, val updoot: Boolean)

/**
 * Interceptor to add auth token to requests
 */
class AuthInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // If token has been saved, add it to the request
        MainActivity.AppSettings.data.AuthToken?.let {
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}