package com.example.defeatthetroll.data

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.defeatthetroll.ChatMessage
import com.example.defeatthetroll.R

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
class LoveChatMessageAdapter(private val chatMessages: List<ChatMessage>) :
    RecyclerView.Adapter<LoveChatMessageAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var messageTextView: TextView = itemView.findViewById(R.id.message_txt) as TextView
        var leftPad: Space = itemView.findViewById(R.id.chat_msg_left_pad) as Space
        var rightPad: Space = itemView.findViewById(R.id.chat_msg_right_pad) as Space
    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val chatView = inflater.inflate(R.layout.chat_message, parent, false)
        // Return a new holder instance
        return ViewHolder(chatView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get the data model based on position
        val chatMessage = chatMessages[position]
        // Set item views based on your views and data model
        val textView = viewHolder.messageTextView
        val right = viewHolder.rightPad
        val left = viewHolder.leftPad
        textView.text = chatMessage.Text
        if (chatMessage.outgoing) {
            textView.setBackgroundColor(Color.rgb(200, 200, 255))
            right.visibility = View.GONE
        } else {
            textView.setBackgroundColor(Color.rgb(255, 200, 200))
            left.visibility = View.GONE
        }
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return chatMessages.size
    }
}