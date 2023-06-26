package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var btnZero: Button
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button
    private lateinit var btnFour: Button
    private lateinit var btnFive: Button
    private lateinit var btnSix: Button
    private lateinit var btnSeven: Button
    private lateinit var btnEight: Button
    private lateinit var btnNine: Button
    private lateinit var btnClear: Button
    private lateinit var btnDivide: Button
    private lateinit var btnPlus: Button
    private lateinit var btnMinus: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnEquals: Button
    private lateinit var etCalculationInput: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the views
        btnZero = findViewById(R.id.btnZero)
        btnOne = findViewById(R.id.btnOne)
        btnTwo = findViewById(R.id.btnTwo)
        btnThree = findViewById(R.id.btnThree)
        btnFour = findViewById(R.id.btnFour)
        btnFive = findViewById(R.id.btnFive)
        btnSix = findViewById(R.id.btnSix)
        btnSeven = findViewById(R.id.btnSeven)
        btnEight = findViewById(R.id.btnEight)
        btnNine = findViewById(R.id.btnNine)
        btnClear = findViewById(R.id.btnClear)
        btnDivide = findViewById(R.id.btnDivide)
        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnEquals = findViewById(R.id.btnEquals)
        etCalculationInput = findViewById(R.id.etCalculationInput)

        var firstNumber = 0
        var secondNumber = 0
        var lastOperation = ""

        // Setting the click listeners
        btnZero.setOnClickListener { etCalculationInput.append("0") }
        btnOne.setOnClickListener { etCalculationInput.append("1") }
        btnTwo.setOnClickListener { etCalculationInput.append("2") }
        btnThree.setOnClickListener { etCalculationInput.append("3") }
        btnFour.setOnClickListener { etCalculationInput.append("4") }
        btnFive.setOnClickListener { etCalculationInput.append("5") }
        btnSix.setOnClickListener { etCalculationInput.append("6") }
        btnSeven.setOnClickListener { etCalculationInput.append("7") }
        btnEight.setOnClickListener { etCalculationInput.append("8") }
        btnNine.setOnClickListener { etCalculationInput.append("9") }

        // Clearing the input
        btnClear.setOnClickListener {
            etCalculationInput.setText("")
            firstNumber = 0
            secondNumber = 0
            lastOperation = ""
        }

        // Performing division

        btnDivide.setOnClickListener {
            if (etCalculationInput.text.toString().isNotEmpty()) {
                firstNumber = etCalculationInput.text.toString().toInt()
                lastOperation = "divide"
                etCalculationInput.setText("")
            }
        }

        // Performing addition

        btnPlus.setOnClickListener {
            if (etCalculationInput.text.toString().isNotEmpty()) {
                firstNumber = etCalculationInput.text.toString().toInt()
                lastOperation = "add"
                etCalculationInput.setText("")
            }
        }

        // Performing subtraction

        btnMinus.setOnClickListener {
            if (etCalculationInput.text.toString().isNotEmpty()) {
                firstNumber = etCalculationInput.text.toString().toInt()
                lastOperation = "subtract"
                etCalculationInput.setText("")
            }
        }

        // Performing multiplication

        btnMultiply.setOnClickListener {
            if (etCalculationInput.text.toString().isNotEmpty()) {
                firstNumber = etCalculationInput.text.toString().toInt()
                lastOperation = "multiply"
                etCalculationInput.setText("")
            }
        }

        // Performing the calculation

        btnEquals.setOnClickListener {
            if (etCalculationInput.text.toString().isNotEmpty()) {
                secondNumber = etCalculationInput.text.toString().toInt()
                when (lastOperation) {
                    "add" -> {
                        etCalculationInput.setText(add(firstNumber, secondNumber).toString())
                    }
                    "subtract" -> {
                        etCalculationInput.setText(subtract(firstNumber, secondNumber).toString())
                    }
                    "multiply" -> {
                        etCalculationInput.setText(multiply(firstNumber, secondNumber).toString())
                    }
                    "divide" -> {
                        etCalculationInput.setText(divide(firstNumber, secondNumber).toString())
                    }
                }
            }
        }


    }

    // Method to perform addition
    private fun add(a: Int, b: Int): Int {
        return a + b
    }

    // Method to perform subtraction

    private fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    // Method to perform multiplication

    private fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    // Method to perform division

    private fun divide(a: Int, b: Int): Int {
        return a / b
    }

}