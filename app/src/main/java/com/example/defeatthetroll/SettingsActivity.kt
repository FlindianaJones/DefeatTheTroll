package com.example.defeatthetroll

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.defeatthetroll.data.ApiService
import com.example.defeatthetroll.data.QuestDatabaseHandler
import kotlinx.android.synthetic.main.activity_settings.*
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.lang.Exception
import java.nio.Buffer
import java.nio.CharBuffer

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
            /*The Retrofit way of doing things*/
            val retrofit = Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                //.addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://troll-defeat-api.herokuapp.com/")
                .build()

            val trollDefeatAPI = retrofit.create(ApiService::class.java)

            val req = trollDefeatAPI.ping()
            val res = req.enqueue(object: Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("troll_network", t.message)
                }

                override fun onResponse(call: Call<String>, response: retrofit2.Response<String>) {
                    Log.d("troll_network", response.body())
                }
            })


            /*The Volley way of doing things
            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)
            val url = "https://troll-defeat-api.herokuapp.com/feedback/ping"

            // Request a string response from the provided URL.
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener { response ->
                    Log.d("troll_network", "Response is: $response")
                },
                Response.ErrorListener { response -> Log.d("troll_network", "Oh no! $response") })

            // Add the request to the RequestQueue.
            queue.add(stringRequest)*/

            /* The raw OkHttpClient way of doing things
            val client = OkHttpClient()

            fun getRequest(url: String): Request = Request.Builder()
                .url(url)
                .build()


            client.newCall(getRequest("https://troll-defeat-api.herokuapp.com/feedback/ping"))
                .enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Log.d("troll_network", e.message)
                    }

                    override fun onResponse(call: Call, response: Response) {
                        val content = response.body()?.byteStream()?.bufferedReader()?.use(BufferedReader::readText)

                        Log.d("troll_network", content)
                    }
                })
            */
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
}
