package com.disabella.mylogin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textLogin = findViewById<TextView>(R.id.textViewLogin)
        val textPassword = findViewById<TextView>(R.id.textViewPassword)
        
    }
}