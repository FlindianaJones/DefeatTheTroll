package com.example.defeatthetroll.shapes

import android.graphics.Canvas
import android.graphics.Paint
import android.util.Log
import kotlin.math.*

class Circle(
    x: Float,
    y: Float,
    val Radius: Double
) : Shape(2 * Radius * PI, x, y, Radius.toFloat()) {

    override fun GradeDrawing(drawing: MutableList<PathPoint>, time: Long): Double {
        var cumulativeRadiusGrade = 0.0
        var cumulativeRoundnessGrade = 0.0
        var drawnLength = 0.0
        var oldX = -1f
        var oldY = -1f
        for (point in drawing) {
            val angleToIdealPoint = point.position * 2.0 * PI //RADIANS, not degrees. sheesh.
            val idealX = CenterX + cos(angleToIdealPoint) * Radius
            val idealY = CenterY + sin(angleToIdealPoint) * Radius

            val dist =
                sqrt((point.x - idealX) * (point.x - idealX) + (point.y - idealY) * (point.y - idealY))
            val pointRadiusGrade = Radius / (Radius + dist)
            cumulativeRadiusGrade += pointRadiusGrade

            //Obviously, the first point would be problematic
            if (oldX > 0 && oldY > 0) {
                val difY = point.y - oldY
                val difX = point.x - oldX
                drawnLength += sqrt(difX * difX + difY * difY)

                var drawnAngle = if (oldX >= 0 && oldY >= 0) {
                    GetAngleFromVector(difX, difY)
                } else {
                    9001f
                }
                var idealAngle = angleToIdealPoint + PI / 2
                if(idealAngle >= 2 * PI){
                    idealAngle -= 2 * PI.toFloat()
                }
                cumulativeRoundnessGrade += GradeAngle(idealAngle.toFloat(), drawnAngle)
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
        return min(//average the radius/roundness grade, so you're graded higher for drawing a really good circle with a constantly wrong radius
            ((cumulativeRadiusGrade+cumulativeRadiusGrade) / (drawing.size*2)) * lengthGrade * min(
                (3000f / time),
                1.25f
            ), 1.0
        )
    }

    override fun Draw(canvas: Canvas, brush: Paint) {
        canvas.drawCircle(CenterX, CenterY, Radius.toFloat(), brush)
    }
}