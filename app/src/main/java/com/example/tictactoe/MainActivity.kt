package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private lateinit var resetButton: Button

    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    private fun init() {

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        resetButton = findViewById(R.id.resetButton)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        resetButton.setOnClickListener(this)

    }

    override fun onClick(clickedView: View?) {

        if (clickedView is Button) {

            var buttonNumber = 0

            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
                R.id.resetButton -> buttonNumber = 10
            }

            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }

        }

    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (buttonNumber == 10) {
            firstPlayer.clear()
            secondPlayer.clear()
            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            resetButton.setBackgroundColor(Color.GRAY)
            button1.setBackgroundColor(Color.GRAY)
            button2.setBackgroundColor(Color.GRAY)
            button3.setBackgroundColor(Color.GRAY)
            button4.setBackgroundColor(Color.GRAY)
            button5.setBackgroundColor(Color.GRAY)
            button6.setBackgroundColor(Color.GRAY)
            button7.setBackgroundColor(Color.GRAY)
            button8.setBackgroundColor(Color.GRAY)
            button9.setBackgroundColor(Color.GRAY)
            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true
            activePlayer = 1

        } else {
            if (activePlayer == 1) {
                clickedView.text = "X"
                firstPlayer.add(buttonNumber)
                activePlayer = 2
            } else {
                clickedView.text = "0"
                secondPlayer.add(buttonNumber)
                activePlayer = 1
            }
            clickedView.isEnabled = false
            check()
        }
    }


    private fun check() {

        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)
                || firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)
                || firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)
                || firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)
                || firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)
                || firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)
                || firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)
                || firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        } else if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)
                || secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)
                || secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)
                || secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)
                || secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)
                || secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)
                || secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)
                || secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        } else {
            if (firstPlayer.size + secondPlayer.size == 9){
                winnerPlayer = 3
            }
        }

        if (winnerPlayer != 0) {
            if (winnerPlayer == 1) {
                Toast.makeText(this, "X wins!", Toast.LENGTH_LONG).show()
            } else if (winnerPlayer == 2){
                Toast.makeText(this, "0 wins!", Toast.LENGTH_LONG).show()
            } else{
                Toast.makeText(this, "გაიმარჯვა მეგობრობამ!", Toast.LENGTH_LONG).show()
            }
            disableButtons()
        }

    }

    private fun disableButtons() {
            if ()
    }

}