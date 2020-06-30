package com.example.defeatthetroll
//~~~   Request Codes
val MEME_REQUEST_CODE = 100
val AXE_REQUEST_CODE = 200
val QUEST_REQUEST_CODE = 300
val LOVE_REQUEST_CODE = 400
val SETTINGS_REQUEST_CODE = 500


//~~~   Database fields
val DATABASE_VERSION = 1
val DATABASE_NAME = "com.example.defeatthetroll"
val QUEST_NODE_TABLE_NAME = "quest_node"
val CHOICE_TABLE_NAME = "choice"

val QUEST_KEY_ID = "id"
val QUEST_KEY_PROMPT = "prompt"

val CHOICE_KEY_ID = "id"
val CHOICE_KEY_NODE_ID = "node_id"
val CHOICE_KEY_KEY = "key"
val CHOICE_KEY_LABEL = "label"
val CHOICE_KEY_KEYWORD = "keyword"
val CHOICE_KEY_RESULT = "result"
val CHOICE_KEY_NEXT = "next_node_id"

//~~    API Constants
val BASE_API_URL = "https://troll-defeat-api.herokuapp.com/"