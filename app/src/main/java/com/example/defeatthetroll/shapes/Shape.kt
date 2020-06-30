package com.example.defeatthetroll.shapes

interface Shape {
    var TotalLength: Double
    var CenterX: Float
    var CenterY: Float

    fun GradeDrawing(drawing: MutableList<PathPoint>): Double
}