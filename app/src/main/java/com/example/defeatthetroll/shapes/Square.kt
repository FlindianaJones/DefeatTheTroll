package com.example.defeatthetroll.shapes

import android.util.Log
import kotlin.math.max
import kotlin.math.sqrt

class Square(
    override var CenterX: Float,
    override var CenterY: Float,
    val SideLength: Double
) : Shape {

    override var TotalLength: Double = 4.0 * SideLength

    override fun GradeDrawing(drawing: MutableList<PathPoint>): Double {
        var cumulativeGradDif = 0.0
        var drawnLength = 0.0
        var oldX = -1f
        var oldY = -1f
        for (point in drawing) {
            var idealX = CenterX * 1.0
            var idealY = CenterY * 1.0
            when {
                //Bottom half of right side (since starting at y=0, x=Side Length/2)
                point.position < 0.125 -> {
                    idealX += SideLength / 2.0
                    idealY += SideLength / 2.0 * (point.position / 0.125) //This gets the progress down the side and judges based on that
                }
                //The bottom side
                point.position < 0.375 -> {
                    idealX += SideLength / 2.0 - ((point.position - 0.125) / 0.25) * SideLength
                    idealY += SideLength / 2.0
                }
                //The right side
                point.position < 0.625 -> {
                    idealX -= SideLength / 2.0
                    idealY += SideLength / 2.0 - ((point.position - 0.375) / 0.25) * SideLength
                }
                //The anti-bottom side
                point.position < 0.875 -> {
                    idealX -= (SideLength / 2.0) - ((point.position - 0.625) / 0.25) * SideLength
                    idealY -= SideLength / 2.0
                }
                //Top half of right side
                point.position > 0.875 -> {
                    idealX += SideLength / 2.0
                    idealY -= SideLength / 2.0 - ((point.position - 0.875) / 0.125) * SideLength / 2.0
                }
            }
            val drawDistFromIdeal =
                sqrt((point.x - idealX) * (point.x - idealX) + (point.y - idealY) * (point.y - idealY))
            val idealDistFromCenter =
                sqrt((CenterX - idealX) * (CenterX - idealX) + (CenterY - idealY) * (CenterY - idealY))
            val pointGrade = if (drawDistFromIdeal < idealDistFromCenter) {
                1 - (drawDistFromIdeal / idealDistFromCenter)
            } else {
                1 - (idealDistFromCenter / drawDistFromIdeal)
            }

            cumulativeGradDif += pointGrade

            //Obviously, the first point would be problematic
            if (oldX > 0 && oldY > 0) {
                val distDrawn = sqrt((point.x - oldX) * (point.x - oldX) + (point.y - oldY) * (point.y - oldY))
                drawnLength += distDrawn
            }
            oldX = point.x
            oldY = point.y
        }
        //thus, the closer you are to having drawn the right length, the better
        val lengthGrade = if (drawnLength > TotalLength) {
            TotalLength / drawnLength
        } else {
            drawnLength / TotalLength
        }
        Log.d("troll_art", "Ideal Length: $TotalLength, Actual: $drawnLength")
        return (cumulativeGradDif / drawing.size) * lengthGrade
    }
}