package com.example.defeatthetroll

import android.content.Context
import android.graphics.*
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.example.defeatthetroll.shapes.Circle
import com.example.defeatthetroll.shapes.Square
import com.example.defeatthetroll.shapes.normalizeFromRightCW
import kotlin.math.*

class Drawing(context: Context?) : View(context) {
    private var playerBrush: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var templateBrush: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var textBrush: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private lateinit var canvas: Canvas
    private var scribble = Path()
    private lateinit var cBitmap: Bitmap // the "c" stands for "canvas"

    private var oldX = 0f
    private var oldY = 0f
    private var grade = 0.0

    private val TOUCH_TOLERANCE = 4f

    private lateinit var requestedCircle: Circle
    private lateinit var requestedSquare: Square

    init {
        playerBrush.color = Color.BLUE
        playerBrush.alpha = 0x80
        playerBrush.strokeWidth = 24f
        playerBrush.style = Paint.Style.STROKE

        templateBrush.color = Color.RED
        templateBrush.strokeWidth = 24f
        templateBrush.style = Paint.Style.STROKE

        textBrush.color = Color.BLACK
        textBrush.textSize = 48f
    }

    override fun draw(c: Canvas?) {
        c!!.save()

        if (!this::requestedCircle.isInitialized) {
            requestedCircle =
                Circle(measuredWidth / 2f, measuredHeight / 2f, measuredWidth * 0.75 * 0.5)
        }

        if (!this::requestedSquare.isInitialized) {
            requestedSquare = Square(measuredWidth / 2f, measuredHeight / 2f, measuredWidth * 0.75)
        }

        cBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888)
        canvas = Canvas(cBitmap)

        canvas.drawColor(Color.WHITE) // the background color
        //canvas.drawCircle(measuredWidth / 2f, measuredHeight / 2f, requestedCircle.Radius.toFloat(), templateBrush)
        canvas.drawRect(
            measuredWidth / 2f - requestedSquare.SideLength.toFloat() / 2f,
            measuredHeight / 2f - requestedSquare.SideLength.toFloat() / 2f,
            measuredWidth / 2 + requestedSquare.SideLength.toFloat() / 2,
            measuredHeight / 2 + requestedSquare.SideLength.toFloat() / 2,
            templateBrush
        )
        canvas.drawPath(scribble, playerBrush)
        if (grade > 0) {
            canvas.drawText(
                "${round(grade * 100)}%",
                measuredWidth / 2f,
                measuredHeight - 24f,
                textBrush
            )
        }

        c.drawBitmap(cBitmap, 0f, 0f, Paint(Paint.DITHER_FLAG))

        c.restore()
        super.draw(canvas)
    }

    private fun touchStart(x: Float, y: Float) {
        scribble = Path()

        scribble.reset()
        scribble.moveTo(x, y)

        oldX = x
        oldY = y
    }

    private fun touchMove(x: Float, y: Float) {
        var dX = abs(x - oldX)
        var dY = abs(y - oldY)

        if (dX >= TOUCH_TOLERANCE || dY >= TOUCH_TOLERANCE) {
            scribble.lineTo(x, y)

            oldX = x
            oldY = y
        }
    }

    private fun touchUp() {
        scribble.lineTo(oldX, oldY)
        val pathApproximation = scribble.approximate(0.5f)
        Log.d("troll_art", "Number of points: ${pathApproximation.size / 3}")
        var pathPoints = normalizeFromRightCW(
            pathApproximation,
            measuredWidth / 2f + requestedSquare.SideLength.toFloat() / 2f,
            //measuredWidth / 2f + requestedCircle.Radius.toFloat(),
            measuredHeight / 2f
        )
        //grade = requestedCircle.GradeDrawing(pathPoints)
        grade = requestedSquare.GradeDrawing(pathPoints)
        //TODO: Encourage speed drawing, grade appropriate how fast they drew
        // Probably compare to...ideal time, by shape, and you get a bonus for being under
        // (this way, if you drew worse, but did so quickly, you get credit)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                touchStart(event.x, event.y)
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                touchMove(event.x, event.y)
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                touchUp()
                invalidate()
            }
        }
        return true
    }
}

