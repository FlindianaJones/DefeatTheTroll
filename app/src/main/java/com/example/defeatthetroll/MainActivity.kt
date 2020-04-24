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

        val memeIntent = Intent(this, Memes::class.java)
        val axeIntent = Intent(this, Axe::class.java)
        val questIntent = Intent(this, Quest::class.java)

        meme_btn.setOnClickListener {
            Log.d("btn_click", "Clicked meme")
            startActivity(memeIntent)
        }

        axe_btn.setOnClickListener {
            Log.d("btn_click", "Clicked axe")
            startActivity(axeIntent)
        }

        quest_btn.setOnClickListener {
            Log.d("btn_click", "Clicked quest")
            startActivity(questIntent)
        }
    }
}
