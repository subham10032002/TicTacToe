package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener{
     var TOTAL_COUNT = 0
    var Player = true
            var tableStatus = Array(3) {IntArray(3)}
    lateinit var table :  Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        table = arrayOf(
               arrayOf(button11,button12,button13),
               arrayOf(button21,button22,button23),
               arrayOf(button31,button32,button33)
        )

        for(i in table)
        {
            for(button in i )
            {
                button.setOnClickListener(this)
            }
        }
        button.setOnClickListener {
            initializeTableStatus()
            TOTAL_COUNT=0
            Player=true
        }
        initializeTableStatus()


    }

    private fun initializeTableStatus() {
       for(i in 0..2)
       {
           for(j in 0..2)
           {
               tableStatus[i][j]=-1;
               table[i][j].isEnabled = true;
               table[i][j].text=""
           }
       }
    }

    override fun onClick(v: View?) {
       when(v?.id)
       {
           R.id.button11 ->{
               updateValue(row=0,col=0,player=Player)
           }
           R.id.button12 ->{
               updateValue(row=0,col=1,player=Player)
           }
           R.id.button13 ->{
               updateValue(row=0, col=2, player=Player)
           }
           R.id.button21 ->{
               updateValue(row=1, col=0, player=Player)
           }
           R.id.button22 ->{
               updateValue(row=1, col=1, player=Player)
           }
           R.id.button23 ->{
               updateValue(row=1, col=2, player=Player)
           }
           R.id.button31 ->{
               updateValue(row=2, col=0, player=Player)
           }
           R.id.button32 ->{
               updateValue(row=2, col=1, player=Player)
           } R.id.button33 ->{
           updateValue(row=2, col=2, player=Player)
       }
       }
    }

    private fun updateValue(row: Int, col: Int, player: Boolean) {
        var text = if(player) "X" else "0"
        var any = if(player) 1 else 0
         table[row][col].apply{
             isEnabled=false
             setText(text)
         }
        tableStatus[row][col] = any
    }


}