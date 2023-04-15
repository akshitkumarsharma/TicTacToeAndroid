package com.example.tictactoegame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class AddPlayer : AppCompatActivity() {

    lateinit var playerOne:EditText
    lateinit var playerTwo:EditText
    lateinit var startGameButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_player)

        playerOne=findViewById(R.id.playerOne)
        playerTwo=findViewById(R.id.playerTwo)
        startGameButton=findViewById(R.id.startGameButton)

        startGameButton.setOnClickListener {
            val getPlayerOneName:String=playerOne.text.toString()
            val getPlayerTwoName:String=playerOne.text.toString()

            if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()) {
                Toast.makeText(this, "Please enter player name", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("playerOne", getPlayerOneName)
                intent.putExtra("playerTwo", getPlayerTwoName)
                startActivity(intent)
                this@AddPlayer.finish()
            }
        }

    }
}