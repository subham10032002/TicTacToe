package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener{

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

        }

    }

    override fun onClick(v: View?) {
       when(v?.id)
       {
           R.id.button11 ->{

           }
           R.id.button12 ->{

           }
           R.id.button13 ->{

           }
           R.id.button21 ->{

           }
           R.id.button22 ->{

           }
           R.id.button23 ->{

           }
           R.id.button31 ->{

           }
           R.id.button32 ->{

           } R.id.button33 ->{

       }
       }
    }
}