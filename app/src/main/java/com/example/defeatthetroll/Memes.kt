package com.example.defeatthetroll

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_memes.*
import kotlin.random.Random

class Memes : AppCompatActivity() {

    var memesTried = mutableSetOf<String>()
    var troll = Troll(Weapon(10, 20, 0, 20, "Executioner Axe"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memes)

        show_meme_btn.setOnClickListener { openGallery() }
    }

    private fun openGallery(){
        val intent = Intent("android.intent.action.GET_CONTENT")
        intent.type = "image/*"
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val imagePath = (data?.data as Uri).toString()
            if (imagePath == "") {
                result_txt.text = getText(R.string.generic_error)
                return
            }
            if(memesTried.contains(imagePath))         {
                result_txt.text = getText(R.string.duplicate_meme_txt)
                return
            }
            memesTried.add(imagePath)
            val damage = getDamageFromString(imagePath)
            Log.d("memes.uploaded", "Got $damage from $imagePath")
            when {
                damage > 40 -> result_txt.text = getText(R.string.meme_high_dmg_txt)
                damage > 20 -> result_txt.text = getText(R.string.meme_med_dmg_txt)
                damage > 0 -> result_txt.text = getText(R.string.meme_low_dmg_txt)
                else -> result_txt.text = getText(R.string.meme_negative_dmg_txt)
            }
            troll.hitpoints -= damage
            if (troll.hitpoints <= 0) {
                Log.d("memes.uploaded", "Sweet victory, here we come!")
                val endIntent = Intent(this, End::class.java)
                endIntent.putExtra(
                    "message",
                    getText(R.string.meme_win_txt)
                )
                endIntent.putExtra("victory", true)
                startActivity(endIntent)
            }
            Log.d("memes.uploaded", "How many memes? ${memesTried.count()}")
            if (memesTried.count() == 5) {
                val endIntent = Intent(this, End::class.java)
                endIntent.putExtra(
                    "message",
                    getText(R.string.meme_loss_txt)
                )
                endIntent.putExtra("victory", false)
                startActivity(endIntent)
            }
        } else {
            result_txt.text = getText(R.string.generic_error)
        }
    }

    private fun getDamageFromString(input: String): Int {
        val lowerCase = input.toLowerCase().replace(Regex("[^\\w\\d]"), "")
        Log.d("getStringSum", "Alphanumeric string = $lowerCase")
        var result = 0
        for(letter in lowerCase){
            val asciiVal = letter.toInt()
            result += if(asciiVal > 96) {
                (asciiVal - 96)//a = 97, ergo -96 should return the alphabet indexed position
            } else {
                asciiVal // this in theory converts a number to the integer, rather than the ascii code it gives for alphas?
            }
        }
        return Random(result).nextInt(100)-50
    }
}
