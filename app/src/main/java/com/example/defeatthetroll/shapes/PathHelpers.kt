package com.example.defeatthetroll.shapes

import android.graphics.Point
import android.util.Log
import kotlin.math.*

// "From Right" in this case means the rightmost point, or: angle 0
fun normalizeFromRightCW(pathApproximation: FloatArray, startX: Float, startY: Float): MutableList<PathPoint> {
    var pathPoints = mutableListOf<PathPoint>()
    var minDist = 9001f
    var minIndex = -1
    var basePercent = -1.0

    for (i in 0 until (pathApproximation.size / 3)) {
        // obviously a bit heavy, but makes it much easier to read
        val percent = pathApproximation[(i * 3)]
        val x = pathApproximation[(i * 3) + 1]
        val y = pathApproximation[(i * 3) + 2]

        val dist = sqrt((startX - x) * (startX - x) + (startY - y) * (startY - y))
        if (dist < minDist) {
            minDist = dist
            minIndex = i
            basePercent = percent.toDouble()
        }
        pathPoints.add(PathPoint(percent.toDouble(), x, y))
    }

    var normalizedPath = mutableListOf<PathPoint>()
    var circularIndex = minIndex
    val direction =
        if (pathPoints[(minIndex + 1) % pathPoints.size].y > pathPoints[minIndex].y) {
            1
        } else {
            -1
        }
    do {
        //adjust the percentage so it increases correctly from the first position we're going to look at
        pathPoints[circularIndex].position = translatePercentage(basePercent, direction, pathPoints[circularIndex].position)
        normalizedPath.add(pathPoints[circularIndex])
        //we add size every time before the modulus to prevent going < 0
        circularIndex = (circularIndex + direction + pathPoints.size) % pathPoints.size
    } while (circularIndex != minIndex)
    return normalizedPath
}

private fun translatePercentage(basePercent: Double, direction: Int, currentPercent: Double): Double {
    var retVal = currentPercent - basePercent
    if (currentPercent < basePercent) {
        retVal++
    }
    if (direction < 0) {
        retVal = 1 - retVal
    }
    return retVal
}

fun detectShape(drawing: MutableList<PathPoint>) {
    var corners = 0
    var sideLengths = mutableListOf<Float>()

    var currentLength = 0f
    var currentDirection = Vector(0f, 0f)//add to the x/y with every point until we decide we're on a corner

    //do this, and the weird for loop, to avoid some weirdness with the first point
    var oldX = drawing[0].x
    var oldY = drawing[0].y

    for(point in drawing.subList(1, drawing.size -1)){
        val newDirection = Vector(point.x - oldX, point.y - oldY)
        Log.d("troll_shape_detect", "c: $currentDirection, n: $newDirection")
        //do some checking
        if(currentDirection.xComponent >= 0 && currentDirection.yComponent >= 0){
            currentLength += sqrt((oldX - point.x) * (oldX - point.x) + (oldY - point.y) * (oldY - point.y))
            val diff = newDirection.distanceBetween(currentDirection)
            if(abs(diff) > PI / 4f) {
                //add this to the corner collection, then reset our current direction
                corners++
                currentDirection = Vector(0f, 0f)
                sideLengths.add(currentLength)
                currentLength = 0f
            } else {
                Log.d("troll_shape_detect", "$diff > ${PI / 4f}")
            }
        }
        currentDirection.add(newDirection)
        oldX = point.x
        oldY = point.y
    }
    sideLengths.add(currentLength)
    Log.d("troll_shape_detect", "Sides: $sideLengths, corners: $corners")
}

private class Vector(var xComponent: Float, var yComponent: Float){
    fun distanceBetween(comparator: Vector): Float {
        return atan(yComponent/xComponent)-atan(comparator.yComponent/comparator.xComponent)
    }

    fun add(toAdd: Vector) {
        xComponent += toAdd.xComponent
        yComponent += toAdd.yComponent
    }

    override fun toString(): String {
        return "(${round(xComponent)}, ${round(yComponent)})"
    }
}

/*
Log.d("troll_shape_detect", "old: ($oldX, $oldY) new: (${point.x}, ${point.y}) currentDirection: $currentDirection")
        if(oldX >= 0 && oldY >= 0){
            if(currentDirection.xComponent >= 0 && currentDirection.yComponent >= 0) {
                //Then, finally having our current direction we start trying to find corners
                currentLength += sqrt((oldX - point.x) * (oldX - point.x) + (oldY - point.y) * (oldY - point.y))
                val newDirection = Vector(point.x - oldX, point.y - oldY)
                Log.d("troll_shape_detect", "newDirection: $newDirection")
                Log.d(
                    "troll_shape_detect",
                    "${round(point.position * 100)}%: $newDirection is ${newDirection.distanceBetween(
                        currentDirection
                    )} different from $currentDirection"
                )
            }
            //the second time through, with an old point but no current direction, we set the current heading
            currentDirection.xComponent += point.x - oldX
            currentDirection.yComponent += point.y - oldY
        }
        //so the first time through the loop, we just set our old position
        oldX = point.x
        oldY = point.y
 */