package com.example.defeatthetroll

import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
class ChatMessageAdapter(private val chatMessages: List<ChatMessage>) : RecyclerView.Adapter<ChatMessageAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var messageTextView: TextView = itemView.findViewById(R.id.message_txt) as TextView
    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatMessageAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.chat_message, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: ChatMessageAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val chatMessage = chatMessages[position]
        // Set item views based on your views and data model
        val textView = viewHolder.messageTextView
        textView.text = chatMessage.Text
        if(chatMessage.outgoing) {
            textView.setBackgroundColor(Color.rgb(200, 200, 255))
            textView.setPadding(120, 0, 0, 0)
        } else {
            textView.setBackgroundColor(Color.rgb(255, 200, 200))
            textView.setPadding(0, 0, 120, 0)
        }
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return chatMessages.size
    }
}