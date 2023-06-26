package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var etCalculationInput: EditText
    private val calculatorModel = CalculatorModel()
    private val calculatorController = CalculatorController(calculatorModel, this)

    fun appendNumber(number: Int) {
        etCalculationInput.append(number.toString())
    }

    fun clearInput() {
        etCalculationInput.text.clear()
    }

    fun setOperation(operation: String) {
        etCalculationInput.append(" $operation ")
    }

    fun getFirstNumber(): Int {
        val input = etCalculationInput.text.toString()
        return input.substring(0, input.indexOf(" ")).toInt()
    }

    fun getSecondNumber(): Int {
        val input = etCalculationInput.text.toString()
        return input.substring(input.indexOf(" ") + 1).toInt()
    }

    fun getOperation(): String {
        val input = etCalculationInput.text.toString()
        return input.substring(input.indexOf(" ") + 1, input.lastIndexOf(" "))
    }

    fun displayResult(result: Int) {
        etCalculationInput.setText(result.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCalculationInput = findViewById(R.id.etCalculationInput)

        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener {
            calculatorController.onClearButtonClick()
        }

        val btnAdd = findViewById<Button>(R.id.btnPlus)
        btnAdd.setOnClickListener {
            calculatorController.onAddButtonClick("add")
        }

        val btnSubtract = findViewById<Button>(R.id.btnMinus)
        btnSubtract.setOnClickListener {
            calculatorController.onAddButtonClick("subtract")
        }

        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        btnMultiply.setOnClickListener {
            calculatorController.onAddButtonClick("multiply")
        }

        val btnDivide = findViewById<Button>(R.id.btnDivide)
        btnDivide.setOnClickListener {
            calculatorController.onAddButtonClick("divide")
        }

        val btnEquals = findViewById<Button>(R.id.btnEquals)
        btnEquals.setOnClickListener {
            calculatorController.onEqualsButtonClick()
        }

        val btn0 = findViewById<Button>(R.id.btnZero)
        btn0.setOnClickListener {
            calculatorController.onNumberButtonClick(0)
        }

        val btn1 = findViewById<Button>(R.id.btnOne)
        btn1.setOnClickListener {
            calculatorController.onNumberButtonClick(1)
        }

        val btn2 = findViewById<Button>(R.id.btnTwo)
        btn2.setOnClickListener {
            calculatorController.onNumberButtonClick(2)
        }

        val btnThree = findViewById<Button>(R.id.btnThree)
        btnThree.setOnClickListener {
            calculatorController.onNumberButtonClick(3)
        }

        val btnFour = findViewById<Button>(R.id.btnFour)
        btnFour.setOnClickListener {
            calculatorController.onNumberButtonClick(4)
        }

        val btnFive = findViewById<Button>(R.id.btnFive)
        btnFive.setOnClickListener {
            calculatorController.onNumberButtonClick(5)
        }

        val btnSix = findViewById<Button>(R.id.btnSix)
        btnSix.setOnClickListener {
            calculatorController.onNumberButtonClick(6)
        }

        val btnSeven = findViewById<Button>(R.id.btnSeven)
        btnSeven.setOnClickListener {
            calculatorController.onNumberButtonClick(7)
        }

        val btnEight = findViewById<Button>(R.id.btnEight)
        btnEight.setOnClickListener {
            calculatorController.onNumberButtonClick(8)
        }

        val btnNine = findViewById<Button>(R.id.btnNine)
        btnNine.setOnClickListener {
            calculatorController.onNumberButtonClick(9)
        }


    }

    class CalculatorModel {

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

    class CalculatorController(private val model: CalculatorModel, private val view: MainActivity) {
        fun onNumberButtonClick(number: Int) {
            view.appendNumber(number)
        }

        fun onClearButtonClick() {
            view.clearInput()
        }

        fun onAddButtonClick(operation: String) {
            view.setOperation(operation)
        }

        fun onEqualsButtonClick() {
            val firstNumber = view.getFirstNumber()
            val secondNumber = view.getSecondNumber()

            val result = when (view.getOperation()) {
                "add" -> model.add(firstNumber, secondNumber)
                "subtract" -> model.subtract(firstNumber, secondNumber)
                "multiply" -> model.multiply(firstNumber, secondNumber)
                "divide" -> model.divide(firstNumber, secondNumber)
                else -> 0
            }

            view.displayResult(result)
        }
    }
}

