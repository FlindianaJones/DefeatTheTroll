package com.example.defeatthetroll

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.defeatthetroll.data.*
import com.example.defeatthetroll.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        val AppSettings = Settings()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        AppSettings.setSelectedBeast(sharedPref.getString(getString(R.string.saved_beast_key), null) ?: getString(R.string.default_beast))
        val authToken = sharedPref.getString(getString(R.string.saved_auth_key), "")
        if(authToken != ""){
            AppSettings.data.AuthToken = authToken
        }
        AppSettings.data.QuestNodes = QuestDatabaseHandler(this).readAllQuestNodes()

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setVariable(BR.selectedBeast, AppSettings)
        binding.executePendingBindings()

        meme_btn.setOnClickListener {
            Log.d("btn_click", "Clicked meme")
            startActivity(Intent(this, Memes::class.java))
        }

        axe_btn.setOnClickListener {
            Log.d("btn_click", "Clicked axe")
            startActivity(Intent(this, Axe::class.java))
        }

        quest_btn.setOnClickListener {
            Log.d("btn_click", "Clicked quest")
            startActivity(Intent(this, Quest::class.java))
        }

        love_btn.setOnClickListener {
            Log.d("btn_click", "Clicked love")
            startActivity(Intent(this, Love::class.java))
        }

        settings_btn.setOnClickListener {
            Log.d("btn_click", "Clicked settings")
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        view_feedback_btn.setOnClickListener{
            Log.d("btn_click", "Clicked View Feedback")
            startActivity(Intent(this, ViewFeedback::class.java))
        }

        login_activity_btn.setOnClickListener{
            Log.d("btn_click", "Click Login")
            startActivity(Intent(this, Login::class.java))
        }

        art_btn.setOnClickListener {
            Log.d("btn_click", "Click Art")
            startActivity(Intent(this, Art::class.java))
        }
    }
}
