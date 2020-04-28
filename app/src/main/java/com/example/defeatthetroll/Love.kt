package com.example.defeatthetroll

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import kotlinx.android.synthetic.main.activity_love.*


class Love : AppCompatActivity() {

    var trollLadyList: ArrayList<TrollLady> = arrayListOf()
    var adapter: TrollLadyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_love)

        // If we came from love profile, having lost
        val bittenLady = intent.getIntExtra("bitten_lady", -1)
        if(bittenLady >= 0){
            trollLadyList[bittenLady].bitten = true
            adapter?.notifyItemChanged(bittenLady)
        }

        if(trollLadyList.size == 0) {
            trollLadyList = TrollLady.createTrollLadies(20)
        }

        find_love_btn.setOnClickListener {
            find_love_btn.visibility = View.GONE
            love_prompt.visibility = View.GONE
            // Lookup the recyclerview in activity layout
            love_list.visibility = View.VISIBLE

            love_list.itemAnimator = SlideInUpAnimator()
            // Create adapter passing in the sample user data
            adapter = TrollLadyAdapter(trollLadyList)
            // Attach the adapter to the recyclerview to populate items
            love_list.adapter = adapter
            // Set layout manager to position the items
            love_list.layoutManager = LinearLayoutManager(this)
            // That's all!
        }
    }
}
