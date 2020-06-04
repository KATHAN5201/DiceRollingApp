package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating a dice on activity creation
        val dice = Dice(6)

        //getting reference to button,result_textView by it's resource id
        //R.<type>.<name> --gives resource id of a resource
        val rollButton: Button = findViewById(R.id.roll_button)
        val resultTextView: TextView = findViewById(R.id.result_text)

        rollButton.setOnClickListener { rollDice(dice, resultTextView) }
    }

    //roll a die and update the screen with the result
    private fun rollDice(dice: Dice, resultTextView: TextView) {
        resultTextView.text = dice.roll().toString()
    }
}

//Dice class
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}