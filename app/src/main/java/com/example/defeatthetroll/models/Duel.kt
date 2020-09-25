package com.example.defeatthetroll.models

import android.content.Context
import android.util.Log
import com.example.defeatthetroll.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.random.Random

class Duel {
    var private: Boolean
    var id = UUID.randomUUID().toString().substring(0..7)
    var name: String
    var players = mutableListOf<String>() // don't really care to track their UUID, just their name really
    var trollGuesses = mutableListOf<DuelGuess>()
    var playerChat = mutableListOf<DuelChatMessage>()
    var playerGuesses = mutableListOf<DuelGuess>()
    var solution = ""
    var spellMap = mapOf<String, String>()
    var elementMap = mapOf<String, String>()
    var selected: Boolean? = null
    var createdDate: String


    constructor() {
        private = false
        name = "Game with no Name"
        createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"))
    }

    constructor(privateGame: Boolean, nameOfTheGame: String, appContext: Context) {
        private = privateGame
        name = nameOfTheGame

        createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"))
        elementMap = randomizePairs(appContext.resources.getStringArray(R.array.colors), appContext.resources.getStringArray(R.array.elements))
        spellMap = randomizePairs(appContext.resources.getStringArray(R.array.shapes), appContext.resources.getStringArray(R.array.spells))
        var solutionColor = "vermillion"; var solutionShape = "dodecagon"//these should never be used, but Kotlin is weird about some things
        for(color in elementMap.keys){
            if(elementMap[color] == "Fire") {
                solutionColor = color
                break
            }
        }
        for(shape in spellMap.keys){
            if(spellMap[shape] == "%sball") {
                solutionShape = shape
            }
        }
        this.solution = "$solutionColor : $solutionShape"
    }

    private fun randomizePairs(first: Array<String>, second: Array<String>): Map<String, String>{
        var retVal = mapOf<String, String>()
        for(i in first.indices){
            var key: String
            do {
                key = first.random()
            } while (retVal.containsKey(key))
            var value: String
            do {
                value = second.random()
            } while (retVal.containsValue(value))
            retVal = retVal.plus(Pair(key, value))
        }
        return retVal
    }

    fun loadStaticValues(dbDuel: Duel) {
        this.elementMap = dbDuel.elementMap
        this.spellMap = dbDuel.spellMap
        this.id = dbDuel.id
        this.createdDate = dbDuel.createdDate
        this.solution = dbDuel.solution
        this.name = dbDuel.solution
        this.private = dbDuel.private
    }

    fun getSpellResult(): String? {
        if(playerGuesses.size == 0 || playerGuesses.last().colorGuess == null || playerGuesses.last().shapeGuess == null){
            return null
        }
        val element = elementMap[playerGuesses.last().colorGuess!!]
        return spellMap[playerGuesses.last().shapeGuess!!]?.replace("%s", element!!, true)
    }

    fun getSpellResult(guess: DuelGuess): String? {
        if(guess.colorGuess == null || guess.shapeGuess == null){
            return null
        }
        val element = elementMap[guess.colorGuess!!]
        return spellMap[guess.shapeGuess!!]?.replace("%s", element!!, true)
    }

    fun getTrollGuess(): String {
        var trollShape: String
        var trollColor: String

        do {
            trollColor = elementMap.keys.elementAt(Random.nextInt(elementMap.keys.size - 1))
            trollShape = spellMap.keys.elementAt(Random.nextInt(spellMap.keys.size - 1))
        } while (trollGuesses.any(fun(guess): Boolean { return guess == DuelGuess(trollShape, trollColor) }))

        trollGuesses.add(DuelGuess(trollShape, trollColor))
        Log.d("troll_duel", "Troll is guessing: $trollColor : $trollShape")
        val element = elementMap[trollColor]
        return spellMap[trollShape]?.replace("%s", element!!, true)!!
    }
}