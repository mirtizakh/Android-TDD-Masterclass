package com.example.outsideintddexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val engine = Engine()
        val car = Car(engine, 20.00)

        car.turnOn()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}