package com.roderiklight.ds41_practica_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private var count: String = ""
    private var value: String = ""
    private var accumulator: Int = 0
    private var list : ArrayList<Int> = ArrayList()
    private lateinit var total: TextView
    private lateinit var results: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number = findViewById<EditText>(R.id.number)
        val side = findViewById<EditText>(R.id.sides)
        val roll = findViewById<Button>(R.id.button)
        results = findViewById(R.id.results)
        total = findViewById(R.id.total)

        roll.setOnClickListener {
            count = number.text.toString()
            value = side.text.toString()
            if (count.isBlank() || value.isBlank()) {
                Toast.makeText(this, "Try to actually input the needed stuff this time pls", Toast.LENGTH_SHORT).show()
            }
            else if (count.toInt() == 0){
                Toast.makeText(this, "You can't throw 0 dices wtf", Toast.LENGTH_SHORT).show()
            }
            else{
            try{
            repeat(count.toInt()){
                roller()
                total.text = accumulator.toString()
                results.text = list.toString()
            }
            }
            catch (e: IllegalArgumentException){
                Toast.makeText(this, "Number of sides CANNOT be 0, when have you ever seen a zero-faced dice? Dummy", Toast.LENGTH_LONG).show()
            }
                accumulator = 0
                list.clear()
            }
        }


    }

    private fun roller(){
                val random = Random.nextInt(1,value.toInt() + 1)
                val dice: Dice = (Dice(side = random))
                list.add(random)
                accumulator += dice.side
    }
}