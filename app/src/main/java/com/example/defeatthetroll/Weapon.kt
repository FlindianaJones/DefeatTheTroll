package com.example.defeatthetroll

class Weapon(min:Int, max:Int, def:Int, atk:Int, name:String="") {
    private val minDamage = min
    private val maxDamage = max
    val DefenseBonus = def
    val AttackBonus = atk
    val Name = name

    fun Damage(): Int {
        return (Math.random()*(maxDamage-minDamage)).toInt()+minDamage
    }
}