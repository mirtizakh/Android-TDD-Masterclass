package com.android.android_tdd_masterclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test = Test("Ali",45)
        if(test === test){

        }

    }

    class Test(name:String){

        init {
           name  = "saad"

        }
        constructor(name:String,age:Int): this(name){

        }
        fun test(){
            println(name)
        }
    }
}