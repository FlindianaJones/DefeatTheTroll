package com.example.defeatthetroll

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.defeatthetroll.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        val AppSettings = Settings()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        AppSettings.setSelectedBeast(sharedPref.getString(getString(R.string.saved_beast_key), null) ?: getString(R.string.default_beast))

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
            //Maybe try calling this for result?
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}
