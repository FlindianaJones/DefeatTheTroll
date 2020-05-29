package com.example.defeatthetroll

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.defeatthetroll.data.Choice
import com.example.defeatthetroll.data.QuestNode
import kotlinx.android.synthetic.main.activity_quest.*

class Quest : AppCompatActivity() {

    private var nextQuestId = 1

    companion object {
        val playerKeywords = mutableSetOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)

        continue_btn.setOnClickListener {
            val adventure = Intent(this, QuestChoice::class.java)
            var foundQuest = false
            for(node in MainActivity.AppSettings.data.QuestNodes) {
                if(node.Id == nextQuestId){
                    adventure.putExtra("quest_node", node)
                    foundQuest = true
                    break
                }
            }
            if(foundQuest) {
                startActivityForResult(adventure, nextQuestId)
            } else {
                theEnd()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            //if we get a RESULT_OK, it *really* should not be null; only protect against it so that I don't need tons of null protection
            val chosen = data?.getParcelableExtra("selection") ?: Choice(
                "",
                "ERROR",
                "",
                -1
            )
            output.text = chosen.Result
            //Not every choice has a consequence
            if(chosen.Keyword != "") {
                playerKeywords.add(chosen.Keyword)
            }
            keywords_txt.text = "${getText(R.string.keywords_prefix)}${playerKeywords.toString()}"
            if(chosen.Next > -1) {
                nextQuestId = chosen.Next
            } else {
                theEnd()
            }
        }
    }

    private fun theEnd() {
        val endIntent = Intent(this, End::class.java)
        endIntent.putExtra(
            "message",
            "${output.text}\n\nApologies for this terminal state, but you are dead."
        )
        endIntent.putExtra("victory", false)
        startActivity(endIntent)
        finish()
    }
}
//private val quests = arrayOf(
//        QuestNode(
//            0,
//            "You find yourself in a forest, surrounded by trees. That's how forests work really...birds flutter from tree to tree, and you smell what you believe to be food cooking over a wood fire somewhere nearby.\nWhich direction will you head?",
//            hashMapOf(
//                Pair(
//                    "1",
//                    Choice(
//                        "Left",
//                        "",
//                        "Deciding to follow the left hand rule, you follow the left pathway through the woods, boulders cropping up from time to time.",
//                        100
//                    )
//                ),
//                Pair(
//                    "2",
//                    Choice(
//                        "Right",
//                        "",
//                        "Deciding to follow the right hand rule, you follow the right pathway through the woods, past several trees that look like birches or aspen maybe.",
//                        200
//                    )
//                ),
//                Pair(
//                    "3",
//                    Choice(
//                        "Mobius",
//                        "3D",
//                        "Deciding to follow the...mobius hand rule, you twist through space and time to the other side of reality.",
//                        300
//                    )
//                )
//            )
//        ),
//        QuestNode(
//            100,
//            "Just as you get concerned that the rocks have taken on a blackened, scorched appearance, you hear movement. You discover a red dragon! His wings gleam golden and the two horns that swoop back from his head are gem encrusted and appear to be bound in platinum. The imposing figure greets you with a snarl, \"What business have you in my domain, soft bodied worm! I am Saevam the Vermillion, and I will have my due!\"",
//            hashMapOf(
//                Pair(
//                    "1",
//                    Choice(
//                        "Tell him the Truth",
//                        "Honest",
//                        "He laughs. \"Wretchling, trespasser in my domain, your spirit is as admirable as it is laughable! You wish to defeat the troll? Defeat me first!\"",
//                        101
//                    )
//                ),
//                Pair(
//                    "2",
//                    Choice(
//                        "Dare him to ask you that ONE more time",
//                        "Juvenile",
//                        "He grins. \"I will live your life fifty times over, and have already lived ten of them. I have the time.\"",
//                        100
//                    )
//                ),
//                Pair(
//                    "3",
//                    Choice(
//                        "Challenge him to an arm wrestling contest randomly like a psychopath",
//                        "Arms",
//                        "He is nonplussed. Subtracted, even. Whatever it was he expected, it was clearly not a challenge to physical prowess.",
//                        102
//                    )
//                )
//            )
//        ),
//        QuestNode(
//            200,
//            "Before long, you find a cottage that appears to be made of bones, hundreds of them lashed together. You try and sneak past, but in a poof of white smoke that sounds like a cough, an old man appears before you, wielding a staff fashioned from a single six foot long bone. \"Greetings\" the man says, quietly but with understated intensity",
//            hashMapOf(
//                Pair(
//                    "1",
//                    Choice(
//                        "Offer him an apple",
//                        "Skeletal Hand",
//                        "You proffer an apple with a grin, saying \"Bone Apple Teeth!\" The old man laughs, taking the apple with an uncomfortably emphatic gesture, and bites into it. The apple blackens where he touches it, and he disappears once more, leaving behind a skeletal hand.",
//                        201
//                    )
//                ),
//                Pair(
//                    "2",
//                    Choice(
//                        "Ask him for aid",
//                        "Definitely not Cursed",
//                        "\"Ah, aid is it that you seek? Then the aid you deserve, you shall have.\" He mutters a little, and you feel uneasy, almost as if a shadow comes over your soul.",
//                        201
//                    )
//                ),
//                Pair(
//                    "3",
//                    Choice(
//                        "Apologize and leave",
//                        "Probably Cursed",
//                        "\"No harm done...to me.\" The old man cackles, and you feel uneasy as you slink on down the road. The woods feel less warm, and the bird song sounds more like a funeral dirge.",
//                        201
//                    )
//                )
//            )
//        ),
//        QuestNode(
//            300,
//            "You twist through reality, feeling a bit queasy as you fold through space, and find yourself in a disappointingly mundane glade, in which rests a large...vehicle? Which looks like the head of a Halberd, only the pointy bit is larger than a carriage. A man runs off into the woods as you enter the scene, and a wild eyed hairy man calls out to you. \"Come here, you have the look of adventure about you! Come inside, please!\"",
//            hashMapOf(
//                Pair(
//                    "1",
//                    Choice(
//                        "Get inside the strange vehicle",
//                        "Flash",
//                        "The harried looking man regains some composure, and ushers you in ceremoniously.",
//                        301
//                    )
//                ),
//                Pair(
//                    "2",
//                    Choice(
//                        "Ain\'t nobody got time for this, go back",
//                        "Normal Guy",
//                        "You yeet yourself back through space and time. Bye Felicia!",
//                        0
//                    )
//                ),
//                Pair(
//                    "3",
//                    Choice(
//                        "Follow the fleeing man, he seems more reasonable",
//                        "Earthbound",
//                        "You duck beneath the point of the strange vessel, and head into the underbrush.",
//                        302
//                    )
//                )
//            )
//        ),
//        QuestNode(
//            101,
//            "The dragon exhales, and a line of fire strikes the ground; he traces a circle, locking the two of you together in a large arena rimmed by flame. \"Very well, worm, I will not besmirch my legacy as an honorable and sporting firedrake even with the likes of you. I will let you strike first. Strike hard, strike fast, and strike true!\"",
//            hashMapOf(
//                Pair(
//                    "1",
//                    Choice(
//                        "Show him a really funny meme",
//                        "O RLY",
//                        "He examines your phone closely, almost nearsightedly, then the last thing you see is a wall of fire blasting forth as he laughs. You have only the barest instant to wonder if he thought the meme was funny, or just killing you...",
//                        -1
//                    )
//                ),
//                Pair(
//                    "2",
//                    Choice(
//                        "Swing your axe with all your might!",
//                        "Axe Him to DIE",
//                        "The Axe slightly chips a scale; this seems like progress, until you're swatted like a fly. Maybe you overestimate your effectiveness with an axe.",
//                        -1
//                    )
//                ),
//                Pair(
//                    "3",
//                    Choice(
//                        "Play dead after punching him in the, uh, \"shin.\"",
//                        "Possum",
//                        "You run over, punch him while shouting your most convincing Son Goku impression, then fall to the ground with a dramatic \"URK!\" You think it may be working as there is a moment of silence, before you hear Saevam say \"Surely, thou jesteth.\" And you are tossed in the air, opening your eyes long enough to see his open mouth growing closer and closer...",
//                        -1
//                    )
//                )
//            )
//        ),
//        QuestNode(
//            102,
//            "The dragon thinks quickly, and seems to reach a decision. \"In all my eight hundred years, never has a mortal surprised me so thoroughly nor so strangely. Very well, you shall have your wrestling arms contest. Are you right or left handed?\"",
//            hashMapOf(
//                Pair(
//                    "1",
//                    Choice(
//                        "Left",
//                        "Left Handed",
//                        "The dragon nods. \"I should have known such a peculiar idea came from a sinister handed simpleton.\"",
//                        103
//                    )
//                ),
//                Pair(
//                    "2",
//                    Choice(
//                        "Right",
//                        "Right Handed",
//                        "The dragon nods. \"To be fair, the majority of you mortals are both right handed, and stupid.\"",
//                        103
//                    )
//                ),
//                Pair(
//                    "3",
//                    Choice(
//                        "Mobius",
//                        "Mobius Handed",
//                        "The dragon tilts its head; you appear to have once more baffled it.",
//                        103
//                    )
//                )
//            )
//        ),
//        QuestNode(
//            103,
//            "The dragon curls up on the ground, awkwardly holding up the claw opposite your dominant hand. \"I fail to see what you hope to gain from this, but prepare to be crushed.\"",
//            hashMapOf(
//                Pair(
//                    "Left Handed",
//                    Choice(
//                        "",
//                        "Bauble",
//                        "The awkward way the dragon has to sit to hold up his right claw makes you realize something important; dragons have no arms, only legs! You smugly inform Saevam of this, who looks at his legs and at your arm then laughs. \"Ha! Mortal, you prove your kind may have value yet. Take this bauble and begone.\" You skedaddle with the ruby he tosses you.",
//                        0
//                    )
//                ),
//                Pair(
//                    "Right Handed",
//                    Choice(
//                        "",
//                        "Bauble",
//                        "The awkward way the dragon has to sit to hold up his left claw makes you realize something important; dragons have no arms, only legs! You smugly inform Saevam of this, who looks at his legs and at your arm then laughs. \"Ha! Mortal, you prove your kind may have value yet. Take this bauble and begone.\" You skedaddle with the ruby he tosses you.",
//                        0
//                    )
//                ),
//                Pair(
//                    "Mobius Handed",
//                    Choice(
//                        "",
//                        "Strange Bauble",
//                        "The awkward way the dragon has to sit to hold up a claw makes you realize something important; dragons have no arms, only legs! You smugly inform Saevam of this, who looks at his legs and at your arm then laughs. \"Ha! Mortal, you prove your kind may have value yet. Take this strange bauble and begone.\" You skedaddle with the 4th dimensional ruby he tosses you.",
//                        0
//                    )
//                )
//            )
//        ),
//        QuestNode(
//            201,
//            "The road takes a dip into a valley, and you notice the trees are oozing a sticky yellow resin. It is almost amber in color, a thought that is borne fruition as you round a bend and find a massive egg made of amber, at the center of which is a shining object you struggle to make out. It is encased in a large cage, the bars of which crackle with fell energy.",
//            hashMapOf(
//                Pair(
//                    "1",
//                    Choice(
//                        "Leave, this sucks.",
//                        "Sour Grapes",
//                        "Deciding the danger of interacting with the cage is too high, you head back the way you came, going well around the bone hut.",
//                        0
//                    )
//                ),
//                Pair(
//                    "2",
//                    Choice(
//                        "Stick your hand through the bars",
//                        "Fried",
//                        "You make the very questionable choice to ignore those warning crackles, and shove your arm through the bars. You don't have time to register the pain before you're dead.",
//                        -1
//                    )
//                ),
//                Pair(
//                    "Skeletal Hand",
//                    Choice(
//                        "",
//                        "Open Cage",
//                        "Deciding your own life isn't worth risking but someone else's is, you toss the skeletal hand the mage left with you. It comes to life, and climbs up the cage and undoes the door in it, the crackling fading to nothing.",
//                        202
//                    )
//                ),
//                Pair(
//                    "Open Cage",
//                    Choice(
//                        "",
//                        "",
//                        "Having already opened the cage, you go inside.",
//                        202
//                    )
//                )
//            )
//        ),
//        QuestNode(
//            202,
//            "You peer closer into the depths of the amber egg, trying to discern what could lie at its center. It's hard to make out, but you're pretty sure that it's the fabled MacGuffin, the legendary troll defeating doodad! You're now absolutely certain that you need to crack this egg.",
//            hashMapOf(
//                Pair(
//                    "1",
//                    Choice(
//                        "Punch the egg really hard",
//                        "Son Goku",
//                        "Despite all your rage, this is still just an egg in a cage.",
//                        -1
//                    )
//                ),
//                Pair(
//                    "2",
//                    Choice(
//                        "Try and tip it over",
//                        "Tipsy",
//                        "The egg rocks, but does not roll, it IS quite heavy.",
//                        -1
//                    )
//                ),
//                Pair(
//                    "3",
//                    Choice(
//                        "Admit defeat, return to the crossroads",
//                        "Realistic",
//                        "The egg does not react. Did you...did you expect otherwise?",
//                        -1
//                    )
//                ),
//                Pair(
//                    "Ray Gun",
//                    Choice(
//                        "",
//                        "Keyword",
//                        "Result",
//                        -1
//                    )
//                )
//            )
//        ),
//        QuestNode(
//            9000, "Prompt",
//            hashMapOf(
//                Pair(
//                    "1",
//                    Choice(
//                        "Label",
//                        "Keyword",
//                        "Result",
//                        -1
//                    )
//                ),
//                Pair(
//                    "2",
//                    Choice(
//                        "Label",
//                        "Keyword",
//                        "Result",
//                        -1
//                    )
//                ),
//                Pair(
//                    "3",
//                    Choice(
//                        "Label",
//                        "Keyword",
//                        "Result",
//                        -1
//                    )
//                )
//            )
//        )
//    )
/*
QuestNode:
    -Id (Int, manual)
    -Prompt (String)
Choice:
    -Id (Int, automatic)
    -NodeId (Int, FK)
    -Key (String)
    -Label (String)
    -Keyword (String)
    -Result (String)
    -Next (Int, FK)
 */
