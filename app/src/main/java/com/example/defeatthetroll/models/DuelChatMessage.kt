package com.example.defeatthetroll.models

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DuelChatMessage {
    var message = ""
    var sent = ""
    var sender = ""

    constructor() {
        sender = "Some Scrub"
        message = "NOTHING"
        sent = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"))
    }

    constructor(user: String, content: String){
        sender = user
        message = content
        sent = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"))
    }
}