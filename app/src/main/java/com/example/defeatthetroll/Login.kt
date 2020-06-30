package com.example.defeatthetroll

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.defeatthetroll.data.ApiService
import com.example.defeatthetroll.data.AuthInterceptor
import com.example.defeatthetroll.data.AuthResponse
import com.example.defeatthetroll.data.Credentials
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn.setOnClickListener {
            // TODO: Maybe organize this a little better?
            val retrofit = Builder()
                .client(OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build())//throw in a nice little custom auth interceptor to our HTTP client
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_API_URL)
                .build()

            val trollDefeatAPI = retrofit.create(ApiService::class.java)

            val authReq = trollDefeatAPI.auth(Credentials(login_username_txt.text.toString(), login_password_txt.text.toString()))
            authReq.enqueue(object: Callback<AuthResponse> {
                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                    Log.d("troll_network", t.message)
                    showToast(getString(R.string.login_internal_error))
                }

                override fun onResponse(call: Call<AuthResponse>, response: retrofit2.Response<AuthResponse>) {
                    if(!response.isSuccessful) {
                        Log.d("troll_network", "${response.code()}: ${response.errorBody()?.string()}")
                        if(response.code() >= 500)
                            showToast(getString(R.string.login_internal_error))
                        else
                            showToast("Incorrect credentials, please correct any typing errors!")
                        return
                    }

                    Log.d("troll_network", response.body()?.toString())
                    MainActivity.AppSettings.data.AuthToken = response.body()?.accessToken
                    val sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)

                    with(sharedPref.edit()) {
                        if(remember_me_chk.isChecked) {
                            putString(
                                getString(R.string.saved_auth_key),
                                MainActivity.AppSettings.data.AuthToken
                            )
                        } else {
                            remove(getString(R.string.saved_auth_key))
                        }
                        commit()
                    }
                }
            })
        }
    }

    fun showToast(toast: String?) {
        runOnUiThread {
            Toast.makeText(
                this@Login,
                toast,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}