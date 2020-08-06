package com.example.defeatthetroll

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import com.example.defeatthetroll.shapes.*
import kotlin.math.*

class Drawing(context: Context?) : View(context) {
    private var playerBrush: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var templateBrush: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var textBrush: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private lateinit var canvas: Canvas
    private var scribble = Path()
    private lateinit var cBitmap: Bitmap // the "c" stands for "canvas"
    private var trollScore = 0.0
    private var playerScore = 0.0
    private var tries = 0
    private var oldShape = -1
    private var trollGrades = arrayOf(0.0, 0.0, 0.0)
    var Victory: Boolean? = null

    private var oldX = 0f
    private var oldY = 0f
    private var grade = 0.0

    private val TOUCH_TOLERANCE = 4f

    private lateinit var requestedShape: Shape

    private var startTime: Long = 0

    private lateinit var handler: () -> Unit

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

        for (i in 0..2) {
            val grade = .7 + (Math.random() * 0.3)
            trollGrades[i] = grade
            trollScore += grade
        }
    }

    override fun draw(c: Canvas?) {
        c!!.save()

        cBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888)
        canvas = Canvas(cBitmap)

        canvas.drawColor(Color.WHITE) // the background color

        if (!this::requestedShape.isInitialized) {
            getNewShape()
        }

        requestedShape.Draw(canvas, templateBrush)
        canvas.drawPath(scribble, playerBrush)
        if (grade > 0) {
            canvas.drawText(
                "Your grade: ${round(grade * 100)}% Troll's Grade: ${round(trollGrades[tries-1] * 100)}%",
                measuredWidth / 8f,
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
        startTime = System.currentTimeMillis()
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
        var pathPoints = normalizeFromRightCW(
            pathApproximation,
            measuredWidth / 2f + requestedShape.EdgeDistance,
            measuredHeight / 2f
        )
        val endTime = System.currentTimeMillis()

        grade = requestedShape.GradeDrawing(pathPoints, (endTime - startTime))
        playerScore += grade
        tries++
        if (tries < 3) {
            scribble.reset()
            getNewShape()
        } else {
            Victory = playerScore > trollScore
            handler()
        }
    }


    private fun getNewShape() {
        val maxWidth = measuredWidth * 0.8
        //from 50% of maxwidth to 100% of maxwidth
        val randomWidth = Math.random() * maxWidth * 0.5 + 0.5 * maxWidth
        var newShape = (Math.random() * 2).roundToInt()
        while(newShape == oldShape){
            newShape = (Math.random() * 2).roundToInt()
        }
        requestedShape = when (newShape) {
            0 -> Square(measuredWidth / 2f, measuredHeight / 2f, randomWidth)
            1 -> Circle(measuredWidth / 2f, measuredHeight / 2f, randomWidth * 0.5)//because radius
            else -> Triangle(measuredWidth / 2f, measuredHeight / 2f, randomWidth * 2 / sqrt(3f))
        }
        oldShape = newShape
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

    fun setFinishHandler(h: () -> Unit) {
        handler = h
    }
}

