package com.example.tip_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getTips(view: View){
        editText = findViewById<View>(R.id.editTextNumberDecimal) as EditText

        if (editText.length() >0){
            val amount = editText.text.toString().toDouble()

            var tenPercent = amount+(amount * .10)
            var fiftheenPercent = amount+(amount * .15)
            var twentyPercent = amount+(amount * .20)
            displayTips(tenPercent,fiftheenPercent,twentyPercent)

        }else{

            displayError()

        }
    }

    fun displayTips(tip1:Double,tip2:Double,tip3:Double){
        val textView = findViewById<View>(R.id.textView) as TextView

        textView.text = "Tips are as follows: \n10% = "+"%.2f".format(tip1).toDouble()+"\n15% = "+"%.2f".format(tip2).toDouble()+"\n20% = "+"%.2f".format(tip3).toDouble()
    }

    fun displayError(){
        val textView = findViewById<View>(R.id.textView) as TextView

        textView.text = "YOU MUST ENTER A BILL AMOUNT"
    }
}