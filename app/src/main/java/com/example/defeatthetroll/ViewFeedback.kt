package com.example.defeatthetroll

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.defeatthetroll.models.Feedback
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_view_feedback.*


class ViewFeedback : AppCompatActivity() {

    var feedbacks = mutableListOf<Feedback>()
    val db = FirebaseDatabase.getInstance()
    val myRef = db.getReference("/feedback")

    fun dootFunction(id: String, newRating: Int) {
        myRef.child(id).updateChildren(mapOf(Pair("rating", newRating)))
        /*val retrofit = Retrofit.Builder()
            .client(
                OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()
            )//throw in a nice little custom auth interceptor to our HTTP client
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_API_URL)
            .build()

        val trollDefeatAPI = retrofit.create(ApiService::class.java)

        var dootReq = trollDefeatAPI.doot(DootRequest(id, up))

        dootReq.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("troll_network", t.message ?: "something unspecified went wrong...")
                if (up) {
                    showToast("Failed to updoot, so sorry!")
                } else {
                    showToast("Failed to downdoot, so sorry!")
                }
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (!response.isSuccessful) {
                    Log.d("troll_network", "${response.code()}: ${response.errorBody()?.string()}")
                }

                if (response.body() != null) {
                    Log.d("troll_network", response.body().toString())
                } else {
                    return
                }
                if (up) {
                    showToast("Successfully updooted!")
                } else {
                    showToast("Successfully downdooted.")
                }
                loadFeedbackList()
            }
        })*/
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_feedback)

        val db = FirebaseDatabase.getInstance()
        val myRef = db.getReference("/feedback")

        loadFeedbackList()
    }

    private fun loadFeedbackList() {

        val initialGet = object : ValueEventListener {
            override fun onCancelled(err: DatabaseError) {
                showToast("Oh no!\n$err")
                Log.e("troll_feedback", err.toString())
                Log.e("troll_feedback", db.toString())
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                feedbacks.clear()
                for (fbSnapshot in snapshot.children) {
                    var currFeedback = fbSnapshot.getValue(Feedback::class.java)!!
                    currFeedback.key = fbSnapshot.key.toString()
                    feedbacks.add(currFeedback)
                }
                feedback_list.adapter = FeedbackAdapter(feedbacks, ::dootFunction)
                feedback_list.layoutManager = LinearLayoutManager(applicationContext)
            }
        }

       myRef.addValueEventListener(initialGet)
    }

    /*
    private fun loadFeedbackList() {
        val retrofit = Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build())//throw in a nice little custom auth interceptor to our HTTP client
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_API_URL)
            .build()

        val trollDefeatAPI = retrofit.create(ApiService::class.java)

        val listFeedbackReq = trollDefeatAPI.feedback()

        listFeedbackReq.enqueue(object: Callback<Array<Feedback>> {
            override fun onResponse(
                call: Call<Array<Feedback>>,
                response: Response<Array<Feedback>>
            ) {
                if(response.body() != null){
                    feedback_list.adapter = FeedbackAdapter(response.body()?.asList() ?: listOf(), ::dootFunction)// as usual, clunky null handling in situations where there can no longer be null...
                    feedback_list.layoutManager = LinearLayoutManager(applicationContext)
                }
                else
                    Log.d("troll_network", response.toString())
            }

            override fun onFailure(call: Call<Array<Feedback>>, t: Throwable) {
                Log.d("troll_network", t.message ?: "something unspecified went wrong...")
                showToast("Failed to fetch Feedback, sorry!")
            }
        })
    }
    */

    fun showToast(toast: String?) {
        runOnUiThread {
            Toast.makeText(
                this@ViewFeedback,
                toast,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}