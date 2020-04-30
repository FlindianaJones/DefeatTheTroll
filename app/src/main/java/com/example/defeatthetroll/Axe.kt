package com.example.defeatthetroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_axe.*

class Axe : AppCompatActivity() {

    val weapons = arrayOf(Weapon(0, 20, 0, 10, "War Axe"), Weapon(5, 15, 20, 0, "Peace Axe"), Weapon(5, 15, 10, 10, "War and Peace Axe"))
    var troll = Troll()
    var player = Player()

    val ATTACK_ACTION = 0
    val DEFEND_ACTION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_axe)

        troll = Troll(Weapon(10, 20, 0, 20, "Executioner Axe"), troll_result_txt)
        player = Player(Weapon(0, 0, 0, 0), player_result_txt)

        war_axe_btn.setOnClickListener { lockSFoilsInAttackPosition(0) }
        peace_axe_btn.setOnClickListener { lockSFoilsInAttackPosition(1) }
        war_and_peace_axe_btn.setOnClickListener { lockSFoilsInAttackPosition(2) }

        attack_btn.setOnClickListener { attack() }
        defend_btn.setOnClickListener { defend() }
    }

    private fun endCheck(){
        val endIntent = Intent(this, End::class.java)
        if(troll.hitpoints <= 0) {
            endIntent.putExtra("victory", true)
            endIntent.putExtra("message", "Truly, you will inspire many a generation of adventurers with poor judgement! You triumph, and all sing your praises as you recover in the hospital.")
        } else if(player.hitpoints <= 0){
            endIntent.putExtra("victory", false)
            endIntent.putExtra("message", "You are dork, and eaten by Groo the troll. Better luck next time old chap.")
        }
        if(troll.hitpoints <= 0 || player.hitpoints <= 0) {
            startActivity(endIntent)
            finish()
        }
    }

    private fun attack(){
        when(getTrollAction()) {
            ATTACK_ACTION -> {
                val trollDmg = troll.attack()
                val playerDmg = player.attack()
                if(trollDmg > 0){
                    player.hitpoints -= trollDmg
                    player_result_txt.text = player_result_txt.text.toString() + "\nYou have ${player.hitpoints} hp left."
                }
                if(playerDmg > 0) {
                    troll.hitpoints -= playerDmg
                }
            }
            DEFEND_ACTION -> {
                val trollDmg = troll.defend()
                val playerDmg = player.attack()
                if(trollDmg > 0){
                    player.hitpoints -= trollDmg
                    player_result_txt.text = player_result_txt.text.toString() + "\nYou have ${player.hitpoints} hp left."
                } else {
                    troll.hitpoints -= playerDmg
                }
            }
        }
        //TODO: update color filters based on hitpoints remaining?
        endCheck()
    }

    private fun defend(){
        when(getTrollAction()) {
            ATTACK_ACTION -> {
                val trollDmg = troll.attack()
                val playerDmg = player.defend()
                if(playerDmg > 0){
                    troll.hitpoints -= playerDmg
                } else {
                    player.hitpoints -= trollDmg
                    player_result_txt.text = player_result_txt.text.toString() + "\nYou have ${player.hitpoints} hp left."
                }
            }
            DEFEND_ACTION -> {
                player_result_txt.text = player_result_txt.text.toString() + "\nYou both awkwardly defend at each other, then shake it off and continue."
            }
        }
        //TODO: write a function for color filter updating
        endCheck()
    }

    private fun getTrollAction(): Int{
        //Generate Troll Action
        val coinFlip = (Math.random() * 2).toInt() + 1
        val trollHealthPercent = troll.hitpoints.toFloat() / troll.maxHitpoints.toFloat()
        //choice 0 = attack, 1 = defend
        return when {
            trollHealthPercent > 0.66 -> ATTACK_ACTION //when healthy, only attacks
            trollHealthPercent > 0.33 && coinFlip == 0 -> ATTACK_ACTION // when less healthy, 50% chance to attack
            trollHealthPercent > 0.33 -> DEFEND_ACTION //and 50% chance to defend
            else -> DEFEND_ACTION // when truly low on health, only defends
        }
    }

    fun lockSFoilsInAttackPosition(wpnIndex: Int) {
        player.bequeath(weapons[wpnIndex])
        toggleViewVisibility(war_axe_btn)
        toggleViewVisibility(peace_axe_btn)
        toggleViewVisibility(war_and_peace_axe_btn)
        toggleViewVisibility(attack_btn)
        toggleViewVisibility(defend_btn)
        choice_prompt.text = getText(R.string.action_sel_prompt_txt)
    }

    fun toggleViewVisibility(view: View) {
        view.visibility = if (view.visibility == View.VISIBLE){
            View.GONE
        } else{
            View.VISIBLE
        }
    }
}