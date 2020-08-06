package com.example.defeatthetroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.defeatthetroll.databinding.ActivityArtBinding
import kotlinx.android.synthetic.main.activity_art.*

class Art : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityArtBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_art)
        binding.setVariable(BR.selectedBeast, MainActivity.AppSettings)
        binding.executePendingBindings()

        val canvas = Drawing(this)

        continue_art_btn.setOnClickListener {
            setContentView(canvas)
        }

        canvas.setFinishHandler {
            val endIntent = Intent(this, End::class.java)
            if (canvas.Victory == true) {
                endIntent.putExtra("victory", true)
                endIntent.putExtra("message", "Are you ever good at art just to flex on Hitler? Silly question, you just were! The ${MainActivity.AppSettings.getSelectedBeast()} is defeated.")
            } else {
                endIntent.putExtra("victory", false)
                endIntent.putExtra("message", "Well, uh, the ${MainActivity.AppSettings.getSelectedBeast()} is better at art than you. Just don't apply to any art schools in the near future. Especially if you're real good with people and have a disenfranchised nation with a militaristic background listening to your every word...")
            }
            startActivity(endIntent)
            finish()
        }
    }
}