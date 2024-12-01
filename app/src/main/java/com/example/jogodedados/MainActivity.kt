package com.example.jogodedados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)
        val leftDiceImageView: ImageView = findViewById(R.id.image_leftDice)
        val rightDiceImageView: ImageView = findViewById(R.id.image_rightDice)

        val diceImages = listOf(
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
        )

        rollButton.setOnClickListener {
            val leftDiceRoll = Random.nextInt(0, diceImages.size)
            val rightDiceRoll = Random.nextInt(0, diceImages.size)

            leftDiceImageView.setImageResource(diceImages[leftDiceRoll])
            rightDiceImageView.setImageResource(diceImages[rightDiceRoll])

            val sum = leftDiceRoll + 1 + rightDiceRoll + 1 // Soma dos valores dos dados

            Toast.makeText(this, "Soma dos dados: $sum", Toast.LENGTH_SHORT).show()
        }

        val aboutButton: Button = findViewById(R.id.aboutButton)
        aboutButton.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.dialog_about, null)

            val dialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .create()

            dialogView.findViewById<Button>(R.id.okButton).setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }

    }
}