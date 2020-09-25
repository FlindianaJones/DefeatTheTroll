package com.example.defeatthetroll

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.defeatthetroll.data.TrollLady
import com.example.defeatthetroll.data.TrollLadyAdapter
import com.example.defeatthetroll.databinding.ActivityLoveBinding
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import kotlinx.android.synthetic.main.activity_love.*


class Love : AppCompatActivity() {

    var trollLadyList: ArrayList<TrollLady> = arrayListOf()
    var adapter: TrollLadyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoveBinding = DataBindingUtil.setContentView(this, R.layout.activity_love)
        binding.setVariable(BR.selectedBeast, MainActivity.AppSettings)
        binding.executePendingBindings()

        if (trollLadyList.size == 0) {
            trollLadyList = TrollLady.createTrollLadies(5, this)
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
        //TODO: Don't be lazy, make this bundleable thingy
        profileIntent.putExtra("name", lovelyLady.name)
        profileIntent.putExtra("favorite", lovelyLady.favorite)
        Log.d("troll_favorite", lovelyLady.favorite)
        profileIntent.putExtra("keywords", TrollLady.favorites[lovelyLady.favorite])
        profileIntent.putExtra("profile_pic", lovelyLady.profilePic)
        profileIntent.putExtra("lady_pos", position)
        startActivityForResult(profileIntent, LOVE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LOVE_REQUEST_CODE) {
            val ladyPos = data?.getIntExtra("lady_pos", -1) ?: -1
            if(ladyPos < 0){
                val toast = Toast.makeText(this, "So that was some bad juju magumbo, not sure how you struck out with an imaginary lady.", Toast.LENGTH_LONG)
                toast.show()
                return
            }
            when(resultCode){
                Activity.RESULT_OK -> {
                    val endIntent = Intent(this, End::class.java)
                    endIntent.putExtra("message", "Groo makes a successful love connection with ${trollLadyList[ladyPos].name}, and you defeat him. That's the POWER of love!")
                    endIntent.putExtra("victory", true)
                    startActivity(endIntent)
                    finish()
                }
                Activity.RESULT_FIRST_USER -> {
                    val toast = Toast.makeText(this, "Didn't like the look of that one? Must be nice to have the luxury of pickiness...", Toast.LENGTH_LONG)
                    toast.show()
                }
                Activity.RESULT_CANCELED -> {
                    trollLadyList[ladyPos].bitten = true
                    var allBitten = true
                    for(lady in trollLadyList) {
                        allBitten = allBitten && lady.bitten
                        if (!allBitten)
                            break
                    }
                    if(allBitten){
                        val endIntent = Intent(this, End::class.java)
                        endIntent.putExtra("message", "Having struck out with every lady in a 50 mile radius, Groo kills you with your own phone. Harsh.")
                        endIntent.putExtra("victory", false)
                        startActivity(endIntent)
                        finish()
                    }
                    adapter?.notifyItemChanged(ladyPos)
                }
            }
        }
    }
}
