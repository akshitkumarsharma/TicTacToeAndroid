package com.example.tictactoegame

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultDialog(context: Context, var message: String?, var mainActivity: MainActivity?) :
    Dialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_dialog)

        val messageText = findViewById<TextView>(R.id.messageText)
        val startAgainButton = findViewById<Button>(R.id.startAgainButton)

        messageText.setText(message);

        startAgainButton.setOnClickListener {
            mainActivity?.restartMatch();
            dismiss();
        }
    }
}