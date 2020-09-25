package com.example.defeatthetroll.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.defeatthetroll.R

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
class TrollLadyAdapter(private val ladyTrolls: List<TrollLady>, val parentActivityLauncher: (TrollLady, Int) -> Unit) : RecyclerView.Adapter<TrollLadyAdapter.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row

        // Stores the itemView in a public final member variable that can be used
        // to access the context from any ViewHolder instance.
        var nameTextView: TextView = itemView.findViewById(R.id.contact_name) as TextView
        var viewButton: Button = itemView.findViewById(R.id.view_troll_lady_btn) as Button
    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.troll_lady, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get the data model based on position
        val lovelyLady: TrollLady = ladyTrolls[position]
        // Set item views based on your views and data model
        val textView = viewHolder.nameTextView
        textView.text = lovelyLady.name
        val button = viewHolder.viewButton
        button.text = if (!lovelyLady.bitten) "View Profile" else "Already Bitten"
        button.isEnabled = !lovelyLady.bitten

        button.setOnClickListener {
            parentActivityLauncher(lovelyLady, position)
        }
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return ladyTrolls.size
    }
}