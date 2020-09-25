package com.example.defeatthetroll.data

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.defeatthetroll.R
import com.example.defeatthetroll.models.Duel
import com.example.defeatthetroll.models.Feedback

class DuelAdapter(private val duels: List<Duel>): RecyclerView.Adapter<DuelAdapter.ViewHolder>() {

    var selectedId = ""

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView = itemView.findViewById(R.id.duel_name_txt) as TextView
        var createdTextView: TextView = itemView.findViewById(R.id.duel_created_txt) as TextView
        var background: ConstraintLayout = itemView.findViewById(R.id.duel_item_border) as ConstraintLayout
        var selectArea: ConstraintLayout = itemView.findViewById(R.id.duel_item_select_area) as ConstraintLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.duel_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get the data model based on position
        val duelItem: Duel = duels[position]
        // Set item views based on your views and data model
        viewHolder.createdTextView.text = duelItem.createdDate!!.toString()
        viewHolder.nameTextView.text = duelItem.name
        viewHolder.selectArea.setBackgroundColor(Color.WHITE)
        if(duelItem.selected == true) {
            viewHolder.background.setBackgroundColor(Color.GREEN)
        } else {
            viewHolder.background.setBackgroundColor(Color.WHITE)
        }
        viewHolder.selectArea.setOnClickListener{
            selectedId = duelItem.id
            duels.forEach {
                it.selected = false
            }
            duels[position].selected = true
            notifyDataSetChanged()
        }
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return duels.size
    }

    fun deselectAll() {
        duels.forEach {
            it.selected = false
        }
        notifyDataSetChanged()
    }
}