package com.roderiklight.ds41_practica_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private var value: String = ""
    private var result: Int = 0
    private lateinit var total: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number = findViewById<EditText>(R.id.number)
        val side = findViewById<EditText>(R.id.sides)
        val roll = findViewById<Button>(R.id.button)
        total = findViewById(R.id.total)

        roll.setOnClickListener {
            value = side.text.toString()
            roller()
            total.text = result.toString()
        }


    }

    private fun roller(){
        val random = Random.nextInt(1, value.toInt() + 1)
        val dice: Dice = (Dice(sides = random))
        result = random
    }
}