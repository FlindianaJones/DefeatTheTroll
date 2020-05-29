package com.example.defeatthetroll.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.defeatthetroll.*

class QuestDatabaseHandler(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_QUEST_TABLE = "CREATE TABLE $QUEST_NODE_TABLE_NAME ($QUEST_KEY_ID INTEGER PRIMARY KEY, $QUEST_KEY_PROMPT TEXT)"
        val CREATE_CHOICE_TABLE = "CREATE TABLE $CHOICE_TABLE_NAME ($CHOICE_KEY_ID INTEGER PRIMARY KEY, $CHOICE_KEY_KEY TEXT NOT NULL, $CHOICE_KEY_KEYWORD TEXT NOT NULL, $CHOICE_KEY_LABEL TEXT NOT NULL, $CHOICE_KEY_NEXT INTEGER NOT NULL, $CHOICE_KEY_NODE_ID INTEGER NOT NULL, $CHOICE_KEY_RESULT TEXT NOT NULL, " +
        "FOREIGN KEY($CHOICE_KEY_NODE_ID) REFERENCES $QUEST_NODE_TABLE_NAME($QUEST_KEY_ID), FOREIGN KEY($CHOICE_KEY_NEXT) REFERENCES $QUEST_NODE_TABLE_NAME($QUEST_KEY_ID))"

        db!!.execSQL(CREATE_QUEST_TABLE)
        db.execSQL(CREATE_CHOICE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $CHOICE_TABLE_NAME")
        db.execSQL("DROP TABLE IF EXISTS $QUEST_NODE_TABLE_NAME")

        onCreate(db)
    }

    /// Should not be called in general, as the expectation is that the database comes preloaded with quests, but useful exercise
    fun createQuestNode(node: QuestNode): String{

        val toReturn = StringBuilder()
        with ( writableDatabase) {

            val values = ContentValues()
            values.put(QUEST_KEY_ID, node.Id)
            values.put(QUEST_KEY_PROMPT, node.Prompt)

            insert(QUEST_NODE_TABLE_NAME, null, values)
            Log.d("troll_db", "wrote ${node.Prompt} to ${node.Id}")
            toReturn.append("INSERT INTO $QUEST_NODE_TABLE_NAME ($QUEST_KEY_ID, $QUEST_KEY_PROMPT) VALUES (\"${node.Id}\", \"${node.Prompt}\")")
            close()
        }

        for(i in 0 until node.Choices.size){
            val key = node.Choices.keys.toTypedArray()[i]
            toReturn.append(createChoice(node.Choices[key], key, node.Id))
        }
        return toReturn.toString()
    }

    fun readQuestNode(id: Int): QuestNode {
        with(readableDatabase){
            val cursor = query(QUEST_NODE_TABLE_NAME, arrayOf(QUEST_KEY_ID, QUEST_KEY_PROMPT),
            QUEST_KEY_ID + "=?", arrayOf(id.toString()),
            null, null, null, null)

            cursor?.moveToFirst()

            val choices = readChoices(id)

            return QuestNode(cursor.getInt(cursor.getColumnIndex(QUEST_KEY_ID)), cursor.getString(cursor.getColumnIndex(
                QUEST_KEY_PROMPT)), choices)
        }
    }

    fun readAllQuestNodes(): Array<QuestNode> {
        with(readableDatabase){
            val cursor = query(QUEST_NODE_TABLE_NAME, arrayOf(QUEST_KEY_ID, QUEST_KEY_PROMPT),
                null, null, null, null, null)

            cursor?.moveToFirst()

            val toReturn = arrayListOf<QuestNode>()
            if(cursor.count == 0) {
                return toReturn.toTypedArray()
            }
            do {
                val currentId = cursor.getInt(cursor.getColumnIndex(QUEST_KEY_ID))
                val choices = readChoices(currentId)

                var currentNode = QuestNode(currentId, cursor.getString(cursor.getColumnIndex(QUEST_KEY_PROMPT)), choices)
                toReturn.add(currentNode)
                cursor.moveToNext()
            } while (!cursor.isAfterLast)

            return toReturn.toTypedArray()
        }
    }

    private fun createChoice(choice: Choice?, key: String, parentId: Int): String{
        //doing this for convenience, you should not call with a null choice...
        if(choice == null)
            return ""
        with( writableDatabase){
            var values = ContentValues()
            values.put(CHOICE_KEY_KEY, key)
            values.put(CHOICE_KEY_KEYWORD, choice.Keyword)
            values.put(CHOICE_KEY_LABEL, choice.Label)
            values.put(CHOICE_KEY_NEXT, choice.Next)
            values.put(CHOICE_KEY_NODE_ID, parentId)
            values.put(CHOICE_KEY_RESULT, choice.Result)

            insert(CHOICE_TABLE_NAME, null, values)
            Log.d("troll_db", "wrote ${choice.Label} to $key")
            close()
        }
        return "INSERT INTO $CHOICE_TABLE_NAME ($CHOICE_KEY_KEY, $CHOICE_KEY_KEYWORD, $CHOICE_KEY_LABEL, $CHOICE_KEY_RESULT, $CHOICE_KEY_NEXT, $CHOICE_KEY_NODE_ID)" +
                " VALUES (\"$key\", \"${choice.Keyword}\", \"${choice.Label}\", \"${choice.Result}\", ${choice.Next}, $parentId)"
    }

    fun readChoices(nodeId: Int): HashMap<String, Choice> {
        with(readableDatabase){
            val cursor = query(
                CHOICE_TABLE_NAME, arrayOf(CHOICE_KEY_NEXT, CHOICE_KEY_RESULT, CHOICE_KEY_LABEL, CHOICE_KEY_KEYWORD, CHOICE_KEY_KEY),
                CHOICE_KEY_NODE_ID + "=?", arrayOf(nodeId.toString()),
                null, null, null, null)

            cursor?.moveToFirst()

            val toReturn = hashMapOf<String, Choice>()

            do {
                val currentChoice = Choice(
                    cursor.getString(cursor.getColumnIndex(CHOICE_KEY_LABEL)),
                    cursor.getString(cursor.getColumnIndex( CHOICE_KEY_KEYWORD )),
                    cursor.getString(cursor.getColumnIndex(CHOICE_KEY_RESULT)),
                    cursor.getInt(cursor.getColumnIndex(CHOICE_KEY_NEXT))
                )

                toReturn[cursor.getString(cursor.getColumnIndex(CHOICE_KEY_KEY))] = currentChoice
                cursor.moveToNext()
                Log.d("troll_db", "read ${currentChoice.Label}")
            } while (!cursor.isAfterLast)
            return toReturn
        }
    }
}