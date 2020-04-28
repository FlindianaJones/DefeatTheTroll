package com.example.defeatthetroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
    }
}
