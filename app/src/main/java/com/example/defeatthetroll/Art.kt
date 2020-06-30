package com.example.defeatthetroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Art : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val canvas = Drawing(this)

        setContentView(canvas)
    }
}