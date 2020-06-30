package com.example.defeatthetroll.shapes

import android.util.Log
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class Circle(override var CenterX: Float,
             override var CenterY: Float,
             val Radius: Double): Shape {

    override var TotalLength: Double = 2 * Radius * PI

    override fun GradeDrawing(drawing: MutableList<PathPoint>): Double {
        var cumulativeGradDif = 0.0
        var drawnLength = 0.0
        var oldX = -1f
        var oldY = -1f
        for (point in drawing) {
            val idealAngle = point.position * 2.0 * PI //RADIANS, not degrees. sheesh.
            val idealX = CenterX + cos(idealAngle) * Radius
            val idealY = CenterY + sin(idealAngle) * Radius
            val dist =
                sqrt((point.x - idealX) * (point.x - idealX) + (point.y - idealY) * (point.y - idealY))
            val pointGrade = Radius / (Radius + dist)

            cumulativeGradDif += pointGrade

            //Obviously, the first point would be problematic
            if(oldX > 0 && oldY > 0){
                drawnLength += sqrt((point.x - oldX) * (point.x - oldX) + (point.y - oldY) * (point.y - oldY))
            }
            oldX = point.x
            oldY = point.y
        }
        //thus, the closer you are to having drawn the right length, the better
        val lengthGrade = if(drawnLength > TotalLength) { TotalLength / drawnLength} else {drawnLength / TotalLength}
        Log.d("troll_art", "Ideal Length: $TotalLength, Actual: $drawnLength")
        return (cumulativeGradDif / drawing.size) * lengthGrade
    }
}