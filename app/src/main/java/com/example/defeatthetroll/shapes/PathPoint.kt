package com.example.defeatthetroll.shapes

import kotlin.math.round

// Wait, without the "data" decoration, this doesn't work? Why not?!
data class PathPoint(var position: Double, val x: Float, val y: Float) {
    override fun toString(): String {
        return "%02d%% $x, $y".format(round(position * 100).toInt())
    }
}