package com.example.tictactoegame

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoegame.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    lateinit var clickSound: MediaPlayer
    lateinit var finishSound: MediaPlayer

    private val combinationList: ArrayList<Array<Int>> = ArrayList()


    var binding: ActivityMainBinding? = null
    var boxPositions = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0) //9 zero

    var playerTurn = 1
    var totalSelectedBoxes = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding!!.getRoot());

        clickSound = MediaPlayer.create(this, R.raw.click)
        finishSound = MediaPlayer.create(this, R.raw.finished)

        combinationList.add(arrayOf(0, 1, 2))
        combinationList.add(arrayOf(3, 4, 5))
        combinationList.add(arrayOf(6, 7, 8))
        combinationList.add(arrayOf(0, 3, 6))
        combinationList.add(arrayOf(1, 4, 7))
        combinationList.add(arrayOf(2, 5, 8))
        combinationList.add(arrayOf(2, 4, 6))
        combinationList.add(arrayOf(0, 4, 8))

        val getPlayerOneName = intent.getStringExtra("playerOne")
        val getPlayerTwoName = intent.getStringExtra("playerTwo")

        binding!!.playerOneName.setText(getPlayerOneName);
        binding!!.playerTwoName.setText(getPlayerTwoName);

        binding!!.image1.setOnClickListener {
            clickSound.start()
            if (isBoxSelectable(0)) {
                performAction(it as ImageView, 0)
            }
        }

        binding!!.image2.setOnClickListener {
            clickSound.start()
            if (isBoxSelectable(1)) {
                performAction(it as ImageView, 1)
            }
        }

        binding!!.image3.setOnClickListener {
            clickSound.start()
            if (isBoxSelectable(2)) {
                performAction(it as ImageView, 2)
            }
        }

        binding!!.image4.setOnClickListener {
            clickSound.start()
            if (isBoxSelectable(3)) {
                performAction(it as ImageView, 3)
            }
        }

        binding!!.image5.setOnClickListener {
            clickSound.start()
            if (isBoxSelectable(4)) {
                performAction(it as ImageView, 4)
            }
        }

        binding!!.image6.setOnClickListener {
            clickSound.start()
            if (isBoxSelectable(5)) {
                performAction(it as ImageView, 5)
            }
        }

        binding!!.image7.setOnClickListener {
            clickSound.start()
            if (isBoxSelectable(6)) {
                performAction(it as ImageView, 6)
            }
        }

        binding!!.image8.setOnClickListener {
            clickSound.start()
            if (isBoxSelectable(7)) {
                performAction(it as ImageView, 7)
            }
        }

        binding!!.image9.setOnClickListener {
            clickSound.start()
            if (isBoxSelectable(8)) {
                performAction(it as ImageView, 8)
            }
        }

    }

    private fun performAction(imageView: ImageView, selectedBoxPosition: Int) {
        boxPositions[selectedBoxPosition] = playerTurn
        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.ximage)
            if (checkResults()) {
                finishSound.start()
                val resultDialog = ResultDialog(
                    this@MainActivity, binding!!.playerOneName.text.toString()
                            + " is a Winner!", this@MainActivity
                )
                resultDialog.setCancelable(false)
                resultDialog.show()
            } else if (totalSelectedBoxes == 9) {
                val resultDialog = ResultDialog(this@MainActivity, "Match Draw", this@MainActivity)
                resultDialog.setCancelable(false)
                resultDialog.show()
            } else {
                changePlayerTurn(2)
                totalSelectedBoxes++
            }
        } else {
            imageView.setImageResource(R.drawable.oimage)
            if (checkResults()) {
                finishSound.start()
                val resultDialog = ResultDialog(
                    this@MainActivity, binding!!.playerTwoName.text.toString()
                            + " is a Winner!", this@MainActivity
                )
                resultDialog.setCancelable(false)
                resultDialog.show()
            } else if (totalSelectedBoxes == 9) {
                val resultDialog = ResultDialog(this@MainActivity, "Match Draw", this@MainActivity)
                resultDialog.setCancelable(false)
                resultDialog.show()
            } else {
                changePlayerTurn(1)
                totalSelectedBoxes++
            }
        }
    }



    fun changePlayerTurn(currentPlayerTurn: Int) {
        playerTurn = currentPlayerTurn
        if (playerTurn == 1) {
            binding!!.playerOneLayout.setBackgroundResource(R.drawable.black_border)
            binding!!.playerTwoLayout.setBackgroundResource(R.drawable.white_box)
        } else {
            binding!!.playerTwoLayout.setBackgroundResource(R.drawable.black_border)
            binding!!.playerOneLayout.setBackgroundResource(R.drawable.white_box)
        }
    }
    
    
    fun checkResults(): Boolean {
        var response = false
        for (i in combinationList.indices) {
            val combination: Array<Int> = combinationList[i]
            if (boxPositions[combination[0]] === playerTurn && boxPositions[combination[1]] === playerTurn && boxPositions[combination[2]] === playerTurn) {
                response = true
            }
        }
        return response
    }


    fun isBoxSelectable(boxPosition: Int): Boolean {
        var response = false
        if (boxPositions[boxPosition] === 0) {
            response = true
        }
        return response
    }

    fun restartMatch() {
        boxPositions = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0) //9 zero
        playerTurn = 1
        totalSelectedBoxes = 1
        binding!!.image1.setImageResource(R.drawable.white_box)
        binding!!.image2.setImageResource(R.drawable.white_box)
        binding!!.image3.setImageResource(R.drawable.white_box)
        binding!!.image4.setImageResource(R.drawable.white_box)
        binding!!.image5.setImageResource(R.drawable.white_box)
        binding!!.image6.setImageResource(R.drawable.white_box)
        binding!!.image7.setImageResource(R.drawable.white_box)
        binding!!.image8.setImageResource(R.drawable.white_box)
        binding!!.image9.setImageResource(R.drawable.white_box)
    }
}