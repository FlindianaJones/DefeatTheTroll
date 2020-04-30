package com.example.defeatthetroll

import android.app.Activity
import android.app.Instrumentation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_love_profile.*
import java.lang.Thread.sleep
import java.util.*
import kotlin.concurrent.schedule

class LoveProfile : AppCompatActivity() {
    lateinit var keywords: Array<String>
    var chatMessages: MutableList<ChatMessage> = mutableListOf(ChatMessage("Hello there!", Date(), false))
    var support = 0//need 3 to win, -3 to lose

    var ladypos = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_love_profile)

        name_txt.text = intent.getStringExtra("name")
        favorite_txt.text = intent.getStringExtra("favorite")
        ladypos = intent.getIntExtra("lady_pos", -1)


        keywords = intent.getStringArrayExtra("keywords")

        bite_btn.setOnClickListener {
            send_message_btn.visibility = View.VISIBLE
            message_text_input.visibility = View.VISIBLE

            message_list.visibility = View.VISIBLE
            val adapter = ChatMessageAdapter(chatMessages)
            message_list.adapter = adapter
            message_list.layoutManager = LinearLayoutManager(this)
        }

        send_message_btn.setOnClickListener {
            val msg = message_text_input.text.toString()
            chatMessages.add(chatMessages.size, ChatMessage(msg, Date(), true))
            var supportUp = false
            for(key in keywords){
                if(msg.contains(key)) {
                    support++
                    supportUp = true
                    break
                }
            }
            if(!supportUp) {
                support--
            }
            if(support <= -3){
                setResult(Activity.RESULT_OK)
                intent.putExtra("success", false)
                finish()
            } else if (support >= 3) {
                setResult(Activity.RESULT_OK)
                intent.putExtra("success", true)
                finish()
            }
            message_list.adapter?.notifyDataSetChanged()
            message_text_input.text.clear()
            if(supportUp) {
                sleep(1000)
                chatMessages.add(chatMessages.size, ChatMessage("Ooh la la!", Date(), false))
                message_list.adapter?.notifyDataSetChanged()
            }
        }
    }
}
