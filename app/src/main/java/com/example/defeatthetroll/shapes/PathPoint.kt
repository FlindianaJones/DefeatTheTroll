package com.example.defeatthetroll.shapes

import kotlin.math.round

// Wait, without the "data" decoration, this doesn't work? Why not?!
data class PathPoint(var position: Double, val x: Float, val y: Float) {
    override fun toString(): String {
        return "${round(position * 100)}%: $x, $y"
    }
}