package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Method to perform addition
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    // Method to perform subtraction

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    // Method to perform multiplication

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    // Method to perform division

    fun divide(a: Int, b: Int): Int {
        return a / b
    }


}