package com.example.defeatthetroll

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.defeatthetroll.data.QuestNode
import kotlinx.android.synthetic.main.activity_quest_choice.*

class QuestChoice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest_choice)

        var thisQuestNode = intent.getParcelableExtra<QuestNode>("quest_node")

        var keywordOption = ""
        for (choiceKey in thisQuestNode.Choices.keys) {
            for (playerKey in Quest.playerKeywords) {
                keywordOption = if (playerKey == choiceKey) choiceKey else ""
                if (keywordOption != "") break
            }
            if (keywordOption != "") break
        }
        promptResult.text = thisQuestNode.Prompt

        //the standard, you don't have a keyword skip option
        if (keywordOption == "") {
            if (thisQuestNode.Choices["1"] != null) {
                choice1.text = thisQuestNode.Choices["1"]?.Label
                choice1.setOnClickListener {
                    this.intent.putExtra("selection", thisQuestNode.Choices["1"])
                    setResult(Activity.RESULT_OK, this.intent)
                    finish()
                }
            } else {
                choice1.visibility = View.GONE
            }

            if (thisQuestNode.Choices["2"] != null) {
                choice2.text = thisQuestNode.Choices["2"]?.Label
                choice2.setOnClickListener {
                    this.intent.putExtra("selection", thisQuestNode.Choices["2"])
                    setResult(Activity.RESULT_OK, this.intent)
                    finish()
                }
            } else {
                choice2.visibility = View.GONE
            }

            if (thisQuestNode.Choices["3"] != null) {
                choice3.text = thisQuestNode.Choices["3"]?.Label
                choice3.setOnClickListener {
                    this.intent.putExtra("selection", thisQuestNode.Choices["3"])
                    setResult(Activity.RESULT_OK, this.intent)
                    finish()
                }
            } else {
                choice3.visibility = View.GONE
            }
        } else {
            choice1.text = keywordOption
            promptResult.text =
                "${thisQuestNode.Prompt}\n\nYour previous choices have the following result!"
            choice1.setOnClickListener {
                this.intent.putExtra("selection", thisQuestNode.Choices[keywordOption])
                setResult(Activity.RESULT_OK, this.intent)
                finish()
            }

            choice2.visibility = View.GONE
            choice3.visibility = View.GONE
        }
    }
}
