package com.example.defeatthetroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_end.*
import kotlinx.android.synthetic.main.activity_memes.*

class End : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        victory_msg_txt.text = this.intent.getStringExtra("message")
        if(this.intent.getBooleanExtra("victory", false)) {
            end_splash_txt.text = this.getText(R.string.victory_splash_txt)
        } else {
            end_splash_txt.text = this.getText(R.string.defeat_splash_txt)
        }

        val playAgainIntent = Intent(this, MainActivity::class.java)

        play_again_btn.setOnClickListener { startActivity(playAgainIntent) }
    }
}
