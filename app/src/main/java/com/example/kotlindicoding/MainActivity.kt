package com.example.kotlindicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var btnPlus: Button
    private lateinit var btnMinus : Button
    private lateinit var btnDivide: Button
    private lateinit var btnMultiple: Button
    private lateinit var result: TextView
    private lateinit var btnReset: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        number1 = findViewById(R.id.et_number1)
        number2 = findViewById(R.id.et_number2)
        btnPlus = findViewById(R.id.btn_plus)
        btnMinus = findViewById(R.id.btn_min)
        btnDivide = findViewById(R.id.btn_divide)
        btnMultiple = findViewById(R.id.btn_multiple)
        btnReset = findViewById(R.id.btn_reset)
        result = findViewById(R.id.tv_result)
        btnPlus.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
        btnMultiple.setOnClickListener(this)
        btnReset.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btn_plus -> {
                calcResult { input1, input2 -> input1 + input2 }
            }
            R.id.btn_min -> {
                calcResult { input1, input2 -> input1 - input2 }
            }
            R.id.btn_multiple -> {
                calcResult { input1, input2 -> input1 * input2 }
            }
            R.id.btn_divide -> {
                calcResult { input1, input2 -> input1 / input2 }
            }
            R.id.btn_reset -> resetInput()
        }
    }

    private fun calcResult(calculation: (Double, Double) -> Double) {
        val input1 = number1.text.toString().trim().toDouble()
        val input2 = number2.text.toString().trim().toDouble()
        val result1 = calculation(input1, input2)
        result.text = result1.toString()
    }

    private fun resetInput() {
        number1.text.clear()
        number2.text.clear()
        result.text = ""
    }
}



