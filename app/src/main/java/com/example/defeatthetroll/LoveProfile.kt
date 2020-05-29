package com.example.defeatthetroll

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.defeatthetroll.data.TrollLady
import kotlinx.android.synthetic.main.activity_love_profile.*
import java.util.*

class LoveProfile : AppCompatActivity() {
    lateinit var keywords: Array<String>
    var chatMessages: MutableList<ChatMessage> =
        mutableListOf(ChatMessage("Hello there!", Date(), false))
    var support = 0//need 3 to win, -3 to lose

    var ladypos = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_love_profile)

        name_txt.text = intent.getStringExtra("name")
        favorite_txt.text = intent.getStringExtra("favorite")
        ladypos = intent.getIntExtra("lady_pos", -1)
        profile_pic.setImageDrawable(when (intent.getStringExtra("profile_pic")){
            "poppy" -> getDrawable(R.drawable.poppy)
            "branchette" -> getDrawable(R.drawable.branchette)
            "ginger_troll" -> getDrawable(R.drawable.ginger_troll)
            else -> getDrawable(R.drawable.trollette)
        })

        //This appears to be needed, almost as if the extras don't exist properly until observed...
        Log.d("troll_extra", intent.extras.toString())

        keywords = intent.getStringArrayExtra("keywords") ?: arrayOf<String>()


        bite_btn.setOnClickListener {
            send_message_btn.visibility = View.VISIBLE
            message_text_input.visibility = View.VISIBLE
            bite_btn.isEnabled = false

            message_list.visibility = View.VISIBLE
            val adapter = ChatMessageAdapter(chatMessages)
            message_list.adapter = adapter
            val lm = LinearLayoutManager(this)
            lm.stackFromEnd = true
            message_list.layoutManager = lm
        }

        cancel_love_btn.setOnClickListener {
            //Literally no idea what this even means, but it's not success or cancelled, so here we are
            setResult(Activity.RESULT_FIRST_USER)
            finish()
        }

        send_message_btn.setOnClickListener {
            if (send_message_btn.text == "Send") {
                val msg = message_text_input.text.toString()
                chatMessages.add(chatMessages.size, ChatMessage(msg, Date(), true))
                var supportUp = false
                for (key in keywords) {
                    if (msg.toLowerCase().contains(key.toLowerCase()) && msg.length > key.length) {
                        support++
                        supportUp = true
                        break
                    }
                }
                if (!supportUp) {
                    support--
                }
                message_list.adapter?.notifyDataSetChanged()
                message_text_input.text.clear()
                if (supportUp) {
                    chatMessages.add(
                        chatMessages.size,
                        ChatMessage(TrollLady.positiveResponse(this), Date(), false)
                    )
                } else {
                    chatMessages.add(
                        chatMessages.size,
                        ChatMessage(TrollLady.negativeResponse(this), Date(), false)
                    )
                }
                if (support <= -3) {
                    val fail = Intent()
                    fail.putExtra("lady_pos", ladypos)
                    setResult(Activity.RESULT_CANCELED, fail)
                    finish()
                } else if (support >= 3) {
                    message_text_input.visibility = View.INVISIBLE
                    send_message_btn.text = "Continue"
                    chatMessages.add(
                        chatMessages.size,
                        ChatMessage("We should get coffee sometime!", Date(), false)
                    )
                }
                message_list.adapter?.notifyDataSetChanged()
                message_list.scrollToPosition(chatMessages.size - 1);
            } else {
                val win = Intent()
                win.putExtra("lady_pos", ladypos)
                setResult(Activity.RESULT_OK, win)
                finish()
            }
        }
    }
}
