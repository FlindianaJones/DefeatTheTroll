package com.example.defeatthetroll.data

import android.widget.TextView
import com.example.defeatthetroll.MainActivity
import com.example.defeatthetroll.Weapon

abstract class Combatant(wpn: Weapon?, output: TextView?) {
    var maxHitpoints = 0
    var hitpoints = 0
    var axeSkill = 0
    var dodgeSkill = 0
    var name = "Combatant"

    var weapon = wpn
    val output = output

    open fun attack(): Int {
        val swing = (Math.random()*100).toInt()
        return if(swing <= axeSkill + weapon!!.AttackBonus)
            weapon!!.Damage()
        else
            0
    }
    open fun defend(): Int {
        val block = (Math.random()*100).toInt()
        return if(block <= dodgeSkill + weapon!!.DefenseBonus)
            weapon!!.Damage()/2
        else
            0
    }

    fun bequeath(wpn: Weapon){
        weapon = wpn
    }
}

class Player(wpn: Weapon?, output: TextView?) : Combatant(wpn, output) {
    constructor() : this(null, null){}

    init {
        maxHitpoints = 50
        hitpoints = 50
        axeSkill = 40
        dodgeSkill = 80
        name = "You"
    }

    override fun attack(): Int {
        val result = super.attack()
        if(result > 0) {
            output!!.text = "You swing your ${weapon?.Name}, you optimist you, and manage to connect."
        } else {
            output!!.text = "You swing your ${weapon?.Name}, and it (not you) misses! How rude."
        }

        return result
    }

    override fun defend(): Int {

        val result = super.defend()
        if(result > 0) {
            output!!.text = "As the ${MainActivity.AppSettings.getSelectedBeast()} swings, you avoid becoming his next meal, blocking with your trusty ${weapon?.Name}"
        } else {
            output!!.text = "As the ${MainActivity.AppSettings.getSelectedBeast()} swings, your trusty ${weapon?.Name} lets you down; you're hit!"
        }
        return result
    }
}

class Troll(wpn: Weapon?, output: TextView?) : Combatant(wpn, output) {
    constructor() : this(null, null) {}

    constructor(wpn: Weapon?) : this(wpn, null ) {}

    init {
        maxHitpoints = 100
        hitpoints = 100
        axeSkill = 60
        dodgeSkill = 20
        name = "That mean old troll"
    }

    override fun attack(): Int {
        var result = super.attack()
        if(result > 0) {
            output!!.text =
                "The ${MainActivity.AppSettings.getSelectedBeast()} swings his ${weapon?.Name}, predictably; you begin to regret this as he hits!"
        } else {
            output!!.text =
                "The ${MainActivity.AppSettings.getSelectedBeast()} swings his ${weapon?.Name}, predictably; you feel lucky as he totally misses you."
        }
        return result
    }

    override fun defend(): Int {
        var result = super.defend()
        if(result > 0) {
            output!!.text = "The ${MainActivity.AppSettings.getSelectedBeast()} seems unusually cagey, how interesting; he defensively strikes back."
        }else {
            output!!.text = "The ${MainActivity.AppSettings.getSelectedBeast()} seems unusually cagey, how interesting; he attempts to defend and fails."
        }
        return result
    }
}