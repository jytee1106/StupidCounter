package com.example.stupidcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity","onCreate")

        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        counterViewModel.counter.observe(
            this, Observer {
                if(counterViewModel.counter.value == 10){
                    goodJob()
                }
            }
        )

         buttonIncrease.setOnClickListener{
             counterViewModel.increment()
             textviewCounter.text = counterViewModel.counter.value.toString()
         }

        buttonDecrease.setOnClickListener {
            counterViewModel.decrement()
            textviewCounter.text = counterViewModel.counter.value.toString()
        }

    }

    private fun goodJob() {
        Toast.makeText(applicationContext,"Congratulation",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }
}
