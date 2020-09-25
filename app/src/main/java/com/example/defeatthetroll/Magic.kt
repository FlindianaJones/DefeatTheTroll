package com.example.defeatthetroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.defeatthetroll.data.DuelAdapter
import com.example.defeatthetroll.data.FeedbackAdapter
import com.example.defeatthetroll.models.Duel
import com.example.defeatthetroll.models.Feedback
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import kotlinx.android.synthetic.main.activity_magic.*
import kotlinx.android.synthetic.main.activity_view_feedback.*


class Magic : AppCompatActivity() {

    val db = FirebaseDatabase.getInstance()
    val myRef = db.getReference("/duels")
    val mAuth = FirebaseAuth.getInstance()
    val mUser = mAuth.currentUser

    // TODO: Paginate, since a large amount of duels causes strange issues
    // TODO: Probably would make sense to have separate objects for public vs private duels, since you can't really query by duel privacy it seems, at least not in the realtime db
    // TODO: Does it make sense to maybe have the actual duel list in their slightly less immediate storage, then just have the players list in realtime? (Since the thing we need fastest is whether you can play the game more)
    // TODO: Inactivate this on going away
    val initialGet = object : ValueEventListener {
        override fun onCancelled(err: DatabaseError) {
            showToast("Oh no!\n$err")
            Log.e("troll_magic", err.toString())
            gameList.clear()
        }

        override fun onDataChange(snapshot: DataSnapshot) {
            gameList.clear()
            for (gameSnapshot in snapshot.children) {
                var currGame = gameSnapshot.getValue(Duel::class.java)!!
                if(!currGame.private && currGame.players.size < 2) {
                    currGame.id = gameSnapshot.key.toString()
                    gameList.add(currGame)
                }
            }
            existing_game_list.adapter = DuelAdapter(gameList)
            existing_game_list.layoutManager = LinearLayoutManager(this@Magic)
            join_game_btn.isEnabled = true
        }
    }

    var gameList = mutableListOf<Duel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magic)

        myRef.addValueEventListener(initialGet)

        create_game_btn.setOnClickListener {
            if (existing_game_list.adapter != null) {
                (existing_game_list.adapter as DuelAdapter).deselectAll()
            }
            if (create_game_btn.text == getString(R.string.create_game_btn_txt)) {
                create_game_btn.text = getString(R.string.confirm_create_game_btn_txt)
                create_game_cont.visibility = View.VISIBLE
                existing_game_cont.visibility = View.GONE
            } else {
                create_game_btn.text = getString(R.string.create_game_btn_txt)
                val newDuel =
                    Duel(private_game_switch.isChecked, magic_game_name_inp.text.toString(), this)
                newDuel.players.add(mUser!!.displayName ?: "Some Scrub")
                myRef.child(newDuel.id).setValue(newDuel).addOnSuccessListener {
                    Toast.makeText(
                        this,
                        "Successfully created game! Waiting on someone else to join...",
                        Toast.LENGTH_LONG
                    ).show()
                    val newGameIntent = Intent(this, DuelActivity::class.java)
                    newGameIntent.putExtra("duel_id", newDuel.id)
                    startActivity(newGameIntent)
                }.addOnCanceledListener {
                    Toast.makeText(this, "Error Creating Game! Sad Face...", Toast.LENGTH_LONG)
                        .show()
                }
                create_game_cont.visibility = View.GONE
            }
        }

        join_game_btn.setOnClickListener {
            val selectedGame = (existing_game_list.adapter as DuelAdapter).selectedId
            val privateGame = existing_game_id_inp.text.toString()
            if (!selectedGame.isNullOrEmpty() || !privateGame.isNullOrEmpty()) {
                val duelId = if(privateGame.isNullOrEmpty()) { selectedGame } else { privateGame }
                val newGameIntent = Intent(this, DuelActivity::class.java)
                newGameIntent.putExtra("duel_id", duelId)
                var joiningGame = Duel() // TODO: handle private game ID entering
                for (game in gameList){
                    if(game.id == duelId){
                        joiningGame = game
                        joiningGame.players.add(mUser?.displayName!!)
                    }
                }
                myRef.child(duelId).child("players").setValue(joiningGame.players)
                startActivity(newGameIntent)
            } else {
                existing_game_cont.visibility = View.VISIBLE
                create_game_cont.visibility = View.GONE
                create_game_btn.text = getString(R.string.create_game_btn_txt)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        myRef.removeEventListener(initialGet)
    }

    override fun onDestroy() {
        super.onDestroy()
        myRef.removeEventListener(initialGet)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        myRef.removeEventListener(initialGet)
    }

    override fun onResume() {
        super.onResume()
        myRef.addValueEventListener(initialGet)
    }

    fun showToast(toast: String?) {
        runOnUiThread {
            Toast.makeText(
                this@Magic,
                toast,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}