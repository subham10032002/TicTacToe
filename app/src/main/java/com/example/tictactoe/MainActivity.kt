package com.example.tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener{
     var TOTAL_COUNT = 0
    var Player = true
            var tableStatus = Array(3) {IntArray(3)}
    lateinit var table :  Array<Array<Button>>
    @SuppressLint("SetTextI18n")
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
            textView.text="Player X Turn"
        }
        initializeTableStatus()


    }

    private fun initializeTableStatus() {
       for(i in 0..2)
       {
           for(j in 0..2)
           {
               tableStatus[i][j]=-1;

           }
       }

        for(i in table)
        {
            for(button in i)
            {
                button.isEnabled = true;
                button.text=""
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
        TOTAL_COUNT++
        Player = !Player
        if(Player)
        {
            updateTextView("Player X Turn")
        }
        else
        {
            updateTextView("Player Y Turn")
        }
        if(TOTAL_COUNT==9)
        {
            updateTextView("Game Draw")
            val builder =  AlertDialog.Builder(this)
                builder.setTitle("Game Draw");
                builder.setMessage("Best of luck for the next turn")
                builder.setPositiveButton("OK"){ _, _ ->

                }

                val alertDialog: AlertDialog = builder.create()
            alertDialog.show()

        }

        checkWinner()

    }
   private fun alert(a :String , b : String)
   {
       val builder =  AlertDialog.Builder(this)
       builder.setTitle(a)
       builder.setMessage(b)
       builder.setPositiveButton("OK"){ _, _ ->

       }

       val alertDialog: AlertDialog = builder.create()
       alertDialog.show()

   }
    private fun checkWinner() {
//        Horizontal winner
        for(i in 0..2)
        {
            if((tableStatus[i][0]==tableStatus[i][1]) && (tableStatus[i][1]==tableStatus[i][2]))
            {
                if(tableStatus[i][0]==1)
                {
                    updateTextView("Player X is Winner")
                    alert("Player X is Winner", " CONGRATULATIONS Player X")
                    disableButton()
                    break
                }
                else if(tableStatus[i][0]==0)
                {
                    updateTextView("Player Y is Winner")
                    alert("Player Y is Winner", " CONGRATULATIONS Player Y")
                    disableButton()
                    break
                }
            }
        }

//        Vertical rows

        for(i in 0..2)
        {
            if((tableStatus[0][i]==tableStatus[1][i]) && (tableStatus[1][i]==tableStatus[2][i]))
            {
                if(tableStatus[0][i]==1)
                {
                    updateTextView("Player X is Winner")
                    alert("Player X is Winner", " CONGRATULATIONS Player X")
                    disableButton()
                    break
                }
                else if(tableStatus[0][i]==0)
                {
                    updateTextView("Player Y is Winner")
                    alert("Player Y is Winner", " CONGRATULATIONS Player Y")
                    disableButton()
                    break
                }
            }
        }
//
////        first diagonal r
//
        if(tableStatus[0][0]==tableStatus[1][1] && tableStatus[1][1]==tableStatus[2][2])
        {
            if(tableStatus[0][0]==1)
            {
                updateTextView("Player X is Winner")
                alert("Player X is Winner", " CONGRATULATIONS Player X")
                disableButton()

            }
            else if(tableStatus[0][0]==0)
            {
                updateTextView("Player Y is Winner")
                alert("Player Y is Winner", " CONGRATULATIONS Player Y")
                disableButton()

            }
        }
//
////        second diagonal
        if(tableStatus[0][2]==tableStatus[1][1] && tableStatus[1][1]==tableStatus[2][0])
        {
            if(tableStatus[0][2]==1)
            {
                updateTextView("Player X is Winner")
                alert("Player X is Winner", " CONGRATULATIONS Player X")
                disableButton()

            }
            else if(tableStatus[0][2]==0)
            {
                updateTextView("Player Y is Winner")
                alert("Player Y is Winner", " CONGRATULATIONS Player Y")
                disableButton()

            }
        }
    }

    private fun updateTextView(s: String) {
          textView.text= s
    }
    private fun disableButton()
    {
        for(i in table)
        {
            for(button in i )
            {
               button.isEnabled=false
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