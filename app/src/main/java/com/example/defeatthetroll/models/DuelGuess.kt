package com.example.defeatthetroll.models

import android.util.Log

class DuelGuess: Comparable<DuelGuess> {
    var shapeGuess: String?
    var colorGuess: String?

    constructor() {
        shapeGuess = null
        colorGuess = null
    }

    constructor(shape: String?, color: String?) {
        shapeGuess = shape
        colorGuess = color
    }

    override fun compareTo(other: DuelGuess): Int {
        return if(other.shapeGuess == this.shapeGuess && other.colorGuess == this.colorGuess) {
            0
        } else {
            //do not care about the non-equal case, we're not sorting on this or anything
            1
        }
    }

    override fun toString(): String {
        return "$colorGuess : $shapeGuess"
    }
}