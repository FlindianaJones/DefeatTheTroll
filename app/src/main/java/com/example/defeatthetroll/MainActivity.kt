package com.example.defeatthetroll

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

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setVariable(BR.selectedBeast, AppSettings)
        binding.executePendingBindings()

        Log.d("troll_beast", AppSettings.getSelectedBeast())

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

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        when(requestCode){
//            SETTINGS_REQUEST_CODE -> {
//                Log.d("troll_beast", AppSettings.getSelectedBeast())
//                binding.notifyPropertyChanged(BR.selectedBeast)
//            }
//        }
//    }
}
