package com.disabella.mylogin

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("main", Context.MODE_PRIVATE)

        val textLogin = findViewById<TextView>(R.id.textViewLogin)
        val textPassword = findViewById<TextView>(R.id.textViewPassword)

        textLogin.text = sharedPref.getString("login", "Your login")
        textPassword.text = sharedPref.getString("password", "Your password")

    }
}