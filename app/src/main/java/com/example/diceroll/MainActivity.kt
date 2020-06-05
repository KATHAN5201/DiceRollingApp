package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        //getting reference to button,result_image_view by it's resource id
        //R.<type>.<name> --gives resource id of a resource
        val rollButton: Button = findViewById(R.id.roll_button)
        val diceImageView: ImageView = findViewById(R.id.dice_image)

        rollButton.setOnClickListener { rollDice(dice, diceImageView) }

        //rolling the dice first time the app opens
        rollDice(dice,diceImageView)
    }

    //roll a die and update the screen with the result
    private fun rollDice(dice: Dice, resultDiceImage: ImageView)
    {
        //choose the image resource depending on the dice roll
        val diceRoll = dice.roll()
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        //updating the image view of result
        resultDiceImage.setImageResource(drawableResource)

        //setting content description for accessibility purpose
        resultDiceImage.contentDescription = diceRoll.toString();

    }
}

//Dice class
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}