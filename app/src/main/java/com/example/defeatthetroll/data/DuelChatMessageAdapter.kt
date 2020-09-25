package com.example.defeatthetroll.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.defeatthetroll.R
import com.example.defeatthetroll.models.DuelChatMessage


class DuelChatAdapter(private val chatMessages: List<DuelChatMessage>): RecyclerView.Adapter<DuelChatAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView = itemView.findViewById(R.id.duel_chat_msg_from_txt) as TextView
        var contentTextView: TextView = itemView.findViewById(R.id.duel_chat_msg_content_txt) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.duel_chat_message, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val duelChatItem: DuelChatMessage = chatMessages[position]
        viewHolder.nameTextView.text = duelChatItem.sender + ":"
        viewHolder.contentTextView.text = duelChatItem.message
    }

    override fun getItemCount(): Int {
        return chatMessages.size
    }
}