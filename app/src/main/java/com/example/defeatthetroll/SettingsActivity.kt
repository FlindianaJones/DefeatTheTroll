package com.example.defeatthetroll

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.defeatthetroll.data.*
import kotlinx.android.synthetic.main.activity_settings.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.lang.Exception

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        ArrayAdapter.createFromResource(
            this,
            R.array.beast_types,
            R.layout.support_simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            beast_type_spn.adapter = adapter
        }

        beast_type_spn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selection = parent?.getItemAtPosition(position) as String
                MainActivity.AppSettings.setSelectedBeast(selection)
                val sharedPref = getSharedPreferences(
                    getString(R.string.preference_file_key),
                    Context.MODE_PRIVATE
                )

                with(sharedPref.edit()) {
                    putString(getString(R.string.saved_beast_key), selection)
                    commit()
                }
            }

        }

        return_btn.setOnClickListener {
            finish()
        }

        post_feedback_btn.setOnClickListener {
            if (feedback_content.visibility != View.VISIBLE) {
                feedback_content_txt.visibility = View.VISIBLE
                feedback_content.visibility = View.VISIBLE
                feedback_title.visibility = View.VISIBLE
                feedback_title_txt.visibility = View.VISIBLE
            } else {
                val retrofit = Retrofit.Builder()
                    .client(OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build())//throw in a nice little custom auth interceptor to our HTTP client
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_API_URL)
                    .build()

                val trollDefeatAPI = retrofit.create(ApiService::class.java)

                //the three final values don't matter, as they're defaulted, but I don't want two separate objects for posting/reading feedbacks
                val postFeedbackReq = trollDefeatAPI.feedback(Feedback(feedback_title.text.toString(), feedback_content.text.toString()))

                postFeedbackReq.enqueue(object: Callback<CreatedResponse>{
                    override fun onFailure(call: Call<CreatedResponse>, t: Throwable) {
                        showToast("Something went wrong trying to post that feedback, try again soon?")
                        Log.d("troll_network", "Oh no! ${t.message}")
                    }

                    override fun onResponse(call: Call<CreatedResponse>, response: Response<CreatedResponse>) {
                        if(!response.isSuccessful) {
                            Log.d("troll_network", "${response.code()}: ${response.errorBody()?.string()}")
                            if(response.code() >= 500) {
                                showToast("Something went wrong trying to post that feedback, try again soon?")
                            } else {
                                showToast("Bad request trying to post that feedback, try logging back in?")
                            }
                            return
                        }
                        if(response.body() == null)
                            return
                        Log.d("troll_network", response.body()?.toString())

                        feedback_content_txt.visibility = View.INVISIBLE
                        feedback_content.visibility = View.INVISIBLE
                        feedback_title.visibility = View.INVISIBLE
                        feedback_title_txt.visibility = View.INVISIBLE
                        feedback_content.setText("")
                        feedback_title.setText("")
                    }
                })
            }
        }

        grant_btn.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .client(OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build())//throw in a nice little custom auth interceptor to our HTTP client
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://amadensor.dyndns.org/~grant/aau/swsf/")
                .build()

            val trollDefeatAPI = retrofit.create(ApiService::class.java)

            val grantReq = trollDefeatAPI.grant(mapOf(Pair("service_request", "{ \"user\": \"2\",\"service\": \"test\",\"action\": \"get\",\"session_key\": \"na\"}")))//GrantRequest(2, "test", "get", "na"))

            grantReq.enqueue(object: Callback<GrantResponse> {
                override fun onFailure(call: Call<GrantResponse>, t: Throwable) {
                    Log.d("troll_grant", "Oh no! ${t.message}")
                }

                override fun onResponse(
                    call: Call<GrantResponse>,
                    response: Response<GrantResponse>
                ) {
                    if(response.body() == null){
                        Log.d("troll_grant", "NULL! ${response.toString()}")
                    } else {
                        Log.d("troll_grant", "Lookie here! ${response.body().toString()}")
                    }
                }
            })
        }

        regen_quests_btn.setOnClickListener {
            try {
                val dbHandler = QuestDatabaseHandler(this)
                dbHandler.onUpgrade(dbHandler.writableDatabase, 0, DATABASE_VERSION)

                with(dbHandler.writableDatabase) {
                    val dbStatements =
                        resources.getStringArray(R.array.db_populate_commands) as Array<String>
                    for (stmt in dbStatements) {
                        execSQL(stmt)
                    }
                }
                MainActivity.AppSettings.data.QuestNodes = dbHandler.readAllQuestNodes()
                val toast = Toast.makeText(
                    this,
                    "Reloaded quest nodes; read ${MainActivity.AppSettings.data.QuestNodes.size} nodes.",
                    Toast.LENGTH_LONG
                )
                toast.show()
            } catch (e: Exception) {
                Log.d("troll_db_err", e.toString())
                val toast = Toast.makeText(this, "Oh No! $e", Toast.LENGTH_LONG)
                toast.show()
            }

        }
    }

    fun showToast(toast: String?) {
        runOnUiThread {
            Toast.makeText(
                this@SettingsActivity,
                toast,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
