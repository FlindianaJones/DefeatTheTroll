package com.example.defeatthetroll

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.defeatthetroll.data.Feedback


class FeedbackAdapter(private val feedbackItems: List<Feedback>, val dootFun: (String, Boolean) -> Unit): RecyclerView.Adapter<FeedbackAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView = itemView.findViewById(R.id.feedback_item_title_txt) as TextView
        var posterTextView: TextView = itemView.findViewById(R.id.feedback_item_poster_txt) as TextView
        var contentTextView: TextView = itemView.findViewById(R.id.feedback_item_content_txt) as TextView
        var updootButton: ImageButton = itemView.findViewById(R.id.updoot_btn) as ImageButton
        var downdootButton: ImageButton = itemView.findViewById(R.id.downdoot_btn) as ImageButton
        var ratingTextView: TextView = itemView.findViewById(R.id.feedback_rating_txt) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedbackAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.feedback_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: FeedbackAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val feedbackItem: Feedback = feedbackItems[position]
        // Set item views based on your views and data model
        viewHolder.titleTextView.text = feedbackItem.title
        viewHolder.posterTextView.text = feedbackItem.poster.firstName + " " + feedbackItem.poster.lastName
        viewHolder.contentTextView.text = feedbackItem.content
        viewHolder.ratingTextView.text = """Rating: ${feedbackItem.rating}"""
        viewHolder.updootButton.setOnClickListener {
            dootFun(feedbackItem._id, true)
        }
        viewHolder.downdootButton.setOnClickListener {
            dootFun(feedbackItem._id, false)
        }
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return feedbackItems.size
    }
}