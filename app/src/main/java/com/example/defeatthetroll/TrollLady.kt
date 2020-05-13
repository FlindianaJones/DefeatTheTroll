package com.example.defeatthetroll

import android.content.Context
import android.content.res.Resources
import kotlin.math.roundToInt

class TrollLady(val name: String, var bitten: Boolean, val favorite: String, val profilePic: String) {

    //need Context passed around because otherwise for some reason it can't find the string arrays...
    companion object {
        fun createTrollLadies(numContacts: Int, context: Context): ArrayList<TrollLady> {
            val contacts = ArrayList<TrollLady>()
            for (i in 1..numContacts) {
                contacts.add(
                    TrollLady(
                        randomName(context),
                        false,
                        randomFromList(R.array.favorites, context),
                        randomFromList(R.array.profile_pics, context)
                    )
                )
            }
            return contacts
        }

        private fun randomName(context: Context): String {
            val firstName = randomFromList(R.array.first_name, context)
            val lastName = randomFromList(R.array.last_name_begin, context) + randomFromList(R.array.last_name_end, context)
            return "$firstName $lastName"
        }

        private fun randomFromList(resourceId: Int, context: Context): String {
            val resourceArray = context.resources.getStringArray(resourceId)
            return resourceArray[(Math.random() * (resourceArray.size - 1)).roundToInt()]
        }

        fun positiveResponse(context: Context) : String {
            return randomFromList(R.array.positive_response, context)
        }

        fun negativeResponse(context: Context) : String {
            return randomFromList(R.array.negative_response, context)
        }

        val favorites = hashMapOf(
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
                "Long Swamp Walks",
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
                "Rescuing Princes",
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
            ),
            Pair(
                "Prequel Memes",
                arrayOf(
                    "general kenobi",
                    "ironic",
                    "not to me",
                    "tragedy",
                    "hate sand",
                    "rank of master",
                    "high ground",
                    "podracing",
                    "intelligent",
                    "unnatural",
                    "sequels suck",
                    "two of them"
                )
            )
        )
    }

}