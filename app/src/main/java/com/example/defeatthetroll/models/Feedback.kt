package com.example.defeatthetroll.models

class Feedback {
    var title: String
    var content: String
    var rating: Int = 1
    var created: String = ""
    var poster: String
    //Not set by default when reading from Firebase
    var key: String = ""


    constructor() {
        this.title = ""
        this.content = ""
        this.poster = ""
    }

    constructor(title: String, content: String, posterName: String){
        this.title = title
        this.content = content
        this.poster = posterName
    }
}