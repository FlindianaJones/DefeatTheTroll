package com.example.defeatthetroll.shapes

import android.graphics.Canvas
import android.graphics.Paint
import kotlin.math.*

class Square(
    x: Float, y: Float,
    val SideLength: Double
) : Shape(4 * SideLength, x, y, SideLength.toFloat() / 2) {

    override fun GradeDrawing(drawing: MutableList<PathPoint>, time: Long): Double {
        var cumulativeDifGrade = 0.0
        var cumulativeSquarenessGrade = 0.0
        var drawnLength = 0.0
        var oldX = -1f
        var oldY = -1f
        for (point in drawing) {
            var idealX = CenterX * 1.0
            var idealY = CenterY * 1.0
            val difY = point.y - oldY
            val difX = point.x - oldX
            var drawnAngle = if (oldX >= 0 && oldY >= 0) {
                GetAngleFromVector(difX, difY)
            } else {
                9001f
            }
            //These ideal angles are Y flipped, because positive Y is down on a screen
            var idealAngle = -1.0f
            when {
                //Bottom half of right side (since starting at y=0, x=Side Length/2)
                point.position < 0.125 -> {
                    idealX += SideLength / 2.0
                    idealY += SideLength / 2.0 * (point.position / 0.125) //This gets the progress down the side and judges based on that
                    idealAngle = PI.toFloat() / 2
                }
                //The bottom side
                point.position < 0.375 -> {
                    idealX += SideLength / 2.0 - ((point.position - 0.125) / 0.25) * SideLength
                    idealY += SideLength / 2.0
                    idealAngle = PI.toFloat()
                }
                //The left side
                point.position < 0.625 -> {
                    idealX -= SideLength / 2.0
                    idealY += SideLength / 2.0 - ((point.position - 0.375) / 0.25) * SideLength
                    idealAngle = 3 * PI.toFloat() / 2
                }
                //The anti-bottom side
                point.position < 0.875 -> {
                    idealX -= (SideLength / 2.0) - ((point.position - 0.625) / 0.25) * SideLength
                    idealY -= SideLength / 2.0
                    idealAngle = 0.0f
                }
                //Top half of right side
                point.position > 0.875 -> {
                    idealX += SideLength / 2.0
                    idealY -= SideLength / 2.0 - ((point.position - 0.875) / 0.125) * SideLength / 2.0
                    idealAngle = PI.toFloat() / 2
                }
            }
            val drawDistFromCenter =
                sqrt((point.x - CenterX) * (point.x - CenterX) + (point.y - CenterY) * (point.y - CenterY)).toDouble()
            val idealDistFromCenter =
                sqrt((CenterX - idealX) * (CenterX - idealX) + (CenterY - idealY) * (CenterY - idealY))
            val pointGrade = 1 - PercentDifference(drawDistFromCenter, idealDistFromCenter)
            if (drawnAngle != 9001f) {
                cumulativeSquarenessGrade += GradeAngle(idealAngle, drawnAngle)
            }

            cumulativeDifGrade += pointGrade

            //Obviously, the first point would be problematic
            if (oldX > 0 && oldY > 0) {
                val distDrawn =
                    sqrt((point.x - oldX) * (point.x - oldX) + (point.y - oldY) * (point.y - oldY))
                drawnLength += distDrawn
            }
            oldX = point.x
            oldY = point.y
        }
        //thus, the closer you are to having drawn the right length, the better
        val lengthGrade = 1.0 - PercentDifference(drawnLength, TotalLength)
        return min(
            (cumulativeDifGrade / drawing.size) * lengthGrade * (cumulativeSquarenessGrade / drawing.size) * min((3000f / time), 1.25f),
            1.0
        )
    }

    override fun Draw(canvas: Canvas, brush: Paint) {
        canvas.drawRect(
            CenterX - SideLength.toFloat() / 2f,
            CenterY - SideLength.toFloat() / 2f,
            CenterX + SideLength.toFloat() / 2,
            CenterY + SideLength.toFloat() / 2,
            brush
        )
    }
}