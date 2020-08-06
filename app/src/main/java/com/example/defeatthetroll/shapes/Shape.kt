package com.example.defeatthetroll.shapes

import android.graphics.Canvas
import android.graphics.Paint
import kotlin.math.*

abstract class Shape(
    var TotalLength: Double,
    var CenterX: Float,
    var CenterY: Float,
    var EdgeDistance: Float
) {
    abstract fun GradeDrawing(drawing: MutableList<PathPoint>, time: Long): Double

    abstract fun Draw(canvas: Canvas, brush: Paint)

    fun PercentDifference(a: Double, b: Double): Double {
        return abs(a - b) / ((a + b) / 2)
    }

    fun GetAngleFromVector(x: Float, y: Float): Float {
        var angle = atan(y / x)
        //Due to the limitations of the ratio used in atan, need to make lengthy list of adjustments based on x/y sign
        if (x < 0 && y > 0) {
            angle += PI.toFloat()
        } else if (x < 0 && y < 0) {
            angle += PI.toFloat()
        } else if (x > 0 && y < 0) {
            angle += PI.toFloat() * 2
        } else if (x > 0 && y == 0f) {
            angle = 0f
        } else if (x < 0 && y == 0f) {
            angle = PI.toFloat()
        } else if (x == 0f && y < 0) {
            angle = 3 * PI.toFloat() / 2
        }
        return angle
    }

    fun GradeAngle(ideal: Float, actual: Float): Double {
        if (ideal == actual || (ideal == 0f && actual.toDouble() == 2 * PI)) {
            return 1.0
        }
        // TODO: Fix This: ideal: 1.5707964, actual: 5.811729, grade: 0.0
        if ((ideal <= PI/2 && actual >= 3*PI/2) || (ideal >= 3*PI/2 && actual <= PI/2)){
            return 1 - ((min(actual, ideal) + (2 * PI) - max(actual, ideal)) / PI)
        }
        // This should tell you how far off you are on a scale of 0 to PI radians, since you can't be more than PI Radians off
        return min(max(0.0, 1 - (abs(actual.toDouble() - ideal) / PI)), 1.0)
    }
}