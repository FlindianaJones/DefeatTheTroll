package com.example.defeatthetroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.defeatthetroll.data.DuelChatAdapter
import com.example.defeatthetroll.models.Duel
import com.example.defeatthetroll.models.DuelChatMessage
import com.example.defeatthetroll.models.DuelGuess
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_duel.*

/*
        So the basic concept here is that you can either start a magic duel, or join an existing one;
        starting a new one creates a "Duel" in the database, giving you the chance to make it private or public as well as generating the duel id
        joining retrieves a list of public duels, and gives the option to enter a private duel ID
        duels contain information about the folks who are dueling as well as of course all their attacks and things; either public or private, and have a unique id

        once inside a duel, you are faced with a troll you must defeat by combining colors and shapes (taking turns) to discover spells (which are randomly generated) to eventually discover fireball (which will end the fight)
        each color will randomly be assigned an element, and each shape will randomly be assigned a spell type, so once you figure out which color is fire, you just need to discover which shape is "ball" so to speak.
        The troll will be randomly guessing every single time, not learning; if it guesses right before you do, game over! (Though, it won't repeat guesses; this leads to a 16% chance it will defeat you)

        Colors (and their non-random counterparts):
        Red - Fire
        Orange - Air
        Yellow - Electricity
        Green - Acid
        Blue - Water
        Indigo - Force
        Violet - Poison

        Shapes (and their non-random counterparts):
        Circle - Ball/Burst/Explosion
        Square - Protection
        Triangle - Summon Elemental
        Star - Ray
        Drop - Transmute Blood
        Trapezoid - Cone of
        Squiggly Line - Power Word
         */

class DuelActivity : AppCompatActivity() {

    val db = FirebaseDatabase.getInstance()
    val myRef = db.getReference("/duels")
    val mAuth = FirebaseAuth.getInstance()
    val mUser = mAuth.currentUser
    lateinit var currentDuel: DatabaseReference
    var clientSideDuel = Duel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_duel)
        deactivateInterface()

        val duelId = this.intent.getStringExtra("duel_id")

        currentDuel = myRef.child(duelId!!)

        val playerListener = object : ChildEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.d("troll_duel", "Error on Player Listener: $error")
                Toast.makeText(
                    this@DuelActivity,
                    "Error on Player Listener: $error",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                clientSideDuel.players.add((snapshot.value as String))
                if (clientSideDuel.players.size == 2) {
                    activateInterface()
                } else {
                    deactivateInterface()
                }
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                clientSideDuel.players.removeAt(snapshot.key?.toInt()!!)
                if (clientSideDuel.players.size == 2) {
                    activateInterface()
                } else {
                    deactivateInterface()
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                // This pretty much only happens when we leave, as altering array indexes of player values is how this is implemented
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                Log.d("troll_duel", "moved a player child, how weird")
            }
        }

        currentDuel.child("players").addChildEventListener(playerListener)
    }

    private fun deactivateInterface(message: String = "Waiting for another player to join game...") {
        guess_spnr.isEnabled = false
        guess_btn.isEnabled = false
        send_chat_msg_btn.isEnabled = false
        chat_msg_txt.isEnabled = false
        duel_result_txt.text = message
    }

    private fun activateInterface(message: String = "Make a guess!") {
        guess_spnr.isEnabled = true
        guess_btn.isEnabled = true
        send_chat_msg_btn.isEnabled = true
        chat_msg_txt.isEnabled = true
        duel_result_txt.text = message
    }

    override fun onDestroy() {
        super.onDestroy()

        val newPlayers = clientSideDuel.players.toMutableList()
        newPlayers.remove(mUser?.displayName!!)
        currentDuel.child("players").setValue(newPlayers)
    }
}