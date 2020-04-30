package com.example.defeatthetroll

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        if (trollLadyList.size == 0) {
            trollLadyList = TrollLady.createTrollLadies(20)
        }

        find_love_btn.setOnClickListener {
            find_love_btn.visibility = View.GONE
            love_prompt.visibility = View.GONE
            // Lookup the recyclerview in activity layout
            love_list.visibility = View.VISIBLE

            love_list.itemAnimator = SlideInUpAnimator()
            // Create adapter passing in the sample user data
            adapter = TrollLadyAdapter(trollLadyList, ::loveProfileHandler)
            // Attach the adapter to the recyclerview to populate items
            love_list.adapter = adapter
            // Set layout manager to position the items
            love_list.layoutManager = LinearLayoutManager(this)
            // That's all!
        }
    }

    fun loveProfileHandler(lovelyLady: TrollLady, position: Int) {
        Log.d("troll_view", "Viewing ${lovelyLady.name}")
        val profileIntent = Intent(this, LoveProfile::class.java)
        profileIntent.putExtra("name", lovelyLady.name)
        profileIntent.putExtra("favorite", lovelyLady.favorite)
        profileIntent.putExtra("keywords", TrollLady.favorites[lovelyLady.favorite])
        startActivityForResult(profileIntent, 400 + position)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode in 400..499) {
            val success = data?.getBooleanExtra("success", false) ?: false
            Log.d(
                "troll_bite",
                "Just returned after biting ${trollLadyList[requestCode - 400].name} ${if(success){"successfully"} else {"unsuccessfully"}}"
            )
        }
    }
}
