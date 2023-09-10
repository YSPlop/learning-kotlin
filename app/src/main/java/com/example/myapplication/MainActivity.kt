package com.example.myapplication

import android.hardware.SensorEventListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Roll the dice and update the screen with the result.
     */
//    private fun rollDice() {
//        val dice = Dice(6)
//        val diceRoll = dice.roll()
//        val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()
//    }
//
//    private fun tempSensor(){
//        val tempSensor = SensorActivity()
//        return tempSensor.onSensorChanged()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Create new Dice object with 6 sides and roll it
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tempSensor = SensorActivity()


        // Update the screen with the dice roll
//        val rollButton: Button = findViewById(R.id.button)
//        rollButton.setOnClickListener { rollDice() }
    }


}
