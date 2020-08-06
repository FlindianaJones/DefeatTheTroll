package com.example.defeatthetroll.shapes

import android.graphics.Canvas
import android.graphics.Paint
import android.util.Log
import kotlin.math.PI
import kotlin.math.min
import kotlin.math.sqrt

class Triangle(x: Float,
                y: Float,
                val SideLength: Double): Shape(3 * SideLength, x, y, sqrt(3.0).toFloat() / 4 * SideLength.toFloat())  {

    override fun Draw(canvas: Canvas, brush: Paint) {
        canvas.drawLine(this.CenterX + EdgeDistance, CenterY + SideLength.toFloat() / 2f, CenterX + EdgeDistance, CenterY - SideLength.toFloat() / 2f, brush)
        canvas.drawLine(this.CenterX + EdgeDistance, CenterY - SideLength.toFloat() / 2f, CenterX - EdgeDistance, CenterY, brush)
        canvas.drawLine(this.CenterX - EdgeDistance, CenterY, CenterX + EdgeDistance, CenterY + SideLength.toFloat() / 2f, brush)
    }

    override fun GradeDrawing(drawing: MutableList<PathPoint>, time: Long): Double {
        var cumulativeDistanceGrade = 0.0
        var cumulativePointynessGrade = 0.0
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
            var idealAngle = 9001f
            when {
                //Bottom half of right side (since starting at y=0, x=Side Length/2)
                point.position < 0.166 -> {
                    idealX += EdgeDistance
                    idealY += (point.position / 0.166) * SideLength / 2 //This gets the progress down the side and judges based on that
                    idealAngle = PI.toFloat() / 2
                }
                //The bottom side
                point.position < 0.5 -> {
                    idealX += SideLength / 2 - ((point.position - 0.166) / 0.334) * SideLength
                    idealY += SideLength / 2 - ((point.position - 0.166) / 0.334) * SideLength / 2
                    idealAngle = 7 * PI.toFloat() / 6
                }
                //The top side
                point.position < 0.833 -> {
                    idealX -= SideLength / 2 - ((point.position - 0.5) / 0.33) * SideLength
                    idealY -= ((point.position - 0.5) / 0.33) * SideLength / 2
                    idealAngle = 11 * PI.toFloat() / 6
                }
                //Top half of right side
                point.position > 0.833 -> {
                    idealX += EdgeDistance
                    idealY -= SideLength / 2 - ((point.position - 0.833) / 0.166) * SideLength / 2
                    idealAngle = PI.toFloat() / 2
                }
            }
            val drawDistFromIdeal =
                sqrt((point.x - idealX) * (point.x - idealX) + (point.y - idealY) * (point.y - idealY))
            val idealDistFromCenter =
                sqrt((CenterX - idealX) * (CenterX - idealX) + (CenterY - idealY) * (CenterY - idealY))
            val pointDistanceGrade = if (drawDistFromIdeal < idealDistFromCenter) {
                1 - (drawDistFromIdeal / idealDistFromCenter)
            } else {
                1 - (idealDistFromCenter / drawDistFromIdeal)
            }



            cumulativeDistanceGrade += pointDistanceGrade

            //Obviously, the first point would be problematic
            if (oldX > 0 && oldY > 0) {
                val distDrawn = sqrt((point.x - oldX) * (point.x - oldX) + (point.y - oldY) * (point.y - oldY))
                drawnLength += distDrawn
                if(drawnAngle != 9001f){
                    cumulativePointynessGrade += GradeAngle(idealAngle, drawnAngle)
                }
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
        return min((cumulativeDistanceGrade / drawing.size) * lengthGrade * min((2500f / time), 1.25f) * (cumulativePointynessGrade / drawing.size), 1.0)
    }
}