package com.example.defeatthetroll.shapes

import kotlin.math.round
import kotlin.math.sqrt

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