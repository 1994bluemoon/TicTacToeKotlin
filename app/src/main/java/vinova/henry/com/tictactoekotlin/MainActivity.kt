package vinova.henry.com.tictactoekotlin

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var winner = -1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt1.setOnClickListener(this)
        bt2.setOnClickListener(this)
        bt3.setOnClickListener(this)
        bt4.setOnClickListener(this)
        bt5.setOnClickListener(this)
        bt6.setOnClickListener(this)
        bt7.setOnClickListener(this)
        bt8.setOnClickListener(this)
        bt9.setOnClickListener(this)
        bt_restart.setOnClickListener { newGame() }

    }

    override fun onClick(v: View?) {
        Log.d("bt: ", "clicked")
        val btSelected: Button = v as Button
        var cellId = 0
        when(btSelected.id){
            R.id.bt1 -> cellId = 1
            R.id.bt2 -> cellId = 2
            R.id.bt3 -> cellId = 3
            R.id.bt4 -> cellId = 4
            R.id.bt5 -> cellId = 5
            R.id.bt6 -> cellId = 6
            R.id.bt7 -> cellId = 7
            R.id.bt8 -> cellId = 8
            R.id.bt9 -> cellId = 9
        }
        playGame(cellId, btSelected)
    }

    private fun playGame(cellId: Int, btSelected: Button) {
        if (activePlayer == 1){
            btSelected.text = "X"
            player1.add(cellId)
            activePlayer = 2
        } else{
            btSelected.text = "0"
            player2.add(cellId)
            activePlayer = 1
        }
        btSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner(){
        //row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        //cross 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        //cross 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        if (winner == 1){
            Toast.makeText(this, "Player 1 win", Toast.LENGTH_SHORT).show()
            disableBt()
        } else if(winner == 2){
            Toast.makeText(this, "Player 2 win", Toast.LENGTH_SHORT).show()
            disableBt()
        }
    }

    fun newGame(){
        bt1.text = ""
        bt2.text = ""
        bt3.text = ""
        bt4.text = ""
        bt5.text = ""
        bt6.text = ""
        bt7.text = ""
        bt8.text = ""
        bt9.text = ""

        enableBt()
        winner = -1
        player1 = ArrayList<Int>()
        player2 = ArrayList<Int>()
    }

    fun disableBt(){
        bt1.isEnabled = false
        bt2.isEnabled = false
        bt3.isEnabled = false
        bt4.isEnabled = false
        bt5.isEnabled = false
        bt6.isEnabled = false
        bt7.isEnabled = false
        bt8.isEnabled = false
        bt9.isEnabled = false
    }

    fun enableBt(){
        bt1.isEnabled = true
        bt2.isEnabled = true
        bt3.isEnabled = true
        bt4.isEnabled = true
        bt5.isEnabled = true
        bt6.isEnabled = true
        bt7.isEnabled = true
        bt8.isEnabled = true
        bt9.isEnabled = true
    }
}
