package com.example.defeatthetroll

import kotlin.math.roundToInt

class TrollLady(val name: String, var bitten: Boolean, val favorite: String) {

    companion object {
        fun createTrollLadies(numContacts: Int): ArrayList<TrollLady> {
            val contacts = ArrayList<TrollLady>()
            for (i in 1..numContacts) {
                contacts.add(
                    TrollLady(
                        randomName(),
                        false,
                        randomFromList(favorites.keys.toTypedArray())
                    )
                )
            }
            return contacts
        }

        private fun randomName(): String {
            val firstName = randomFromList(firstNames)
            val lastName = randomFromList(lastnameFirstHalves) + randomFromList(lastnameSecondHalves)
            return "$firstName $lastName"
        }

        private fun randomFromList(list: Array<String>): String {
            return list[(Math.random() * (list.size - 1)).roundToInt()]
        }

        val favorites = hashMapOf<String, Array<String>>(
            Pair(
                "Battle",
                arrayOf(
                    "blood",
                    "kill",
                    "axes",
                    "weapons",
                    "hit",
                    "murder",
                    "win",
                    "die",
                    "death",
                    "destruction",
                    "pillage",
                    "club",
                    "charge",
                    "warcry",
                    "glory",
                    "maim",
                    "wound"
                )
            ),
            Pair(
                "Long walks through the swamp",
                arrayOf(
                    "mud",
                    "flower",
                    "bracken",
                    "cattail",
                    "log",
                    "turtle",
                    "frog",
                    "gas",
                    "bubble",
                    "rats",
                    "stink",
                    "smell",
                    "rock",
                    "lost"
                )
            ),
            Pair(
                "Rescuing princes",
                arrayOf(
                    "dragon",
                    "tower",
                    "castle",
                    "dungeon",
                    "armor",
                    "helmet",
                    "donkey",
                    "sidekick",
                    "kill",
                    "kiss",
                    "frog",
                    "curse",
                    "ancient",
                    "prophecy",
                    "map",
                    "directions",
                    "liopleurodon"
                )
            )
        )
    }

}

val firstNames = arrayOf(
    "Mila",
    "Natalia",
    "Anastasia",
    "Angelina",
    "Lia",
    "Vera",
    "Angela",
    "Nina",
    "Kira",
    "Nadia",
    "Ivanna",
    "Tatiana",
    "Zariyah",
    "Odessa"
)
val lastnameFirstHalves = arrayOf(
    "Green",
    "Strong",
    "Smash",
    "Stink",
    "Swamp",
    "Shrek",
    "Vile",
    "Verdis",
    "Loud",
    "Rage",
    "Hard",
    "Proud"
)
val lastnameSecondHalves = arrayOf(
    "blood",
    "hammer",
    "mouth",
    "breath",
    "butt",
    "donkey",
    "tongue",
    "man",
    "shout",
    "battle",
    "hide",
    "roar"
)