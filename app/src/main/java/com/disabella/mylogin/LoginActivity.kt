package com.disabella.mylogin

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login = findViewById<TextInputLayout>(R.id.loginLayout)
        val password = findViewById<TextInputLayout>(R.id.passwordLayout)
        val sharedPref = getSharedPreferences("main", Context.MODE_PRIVATE)

        @SuppressLint("CommitPrefEdits")
        fun validate(): Int {
            var result = 0
            login.error = if (login.editText?.text.toString() != "admin") {
                "this Login is invalid"
            } else {
                sharedPref.edit().putString("login", login.editText?.text.toString()).apply()
                result += 1
                null
            }
            password.error = if (password.editText?.text.toString() != "pass") {
                "this Password is invalid"
            } else {
                sharedPref.edit().putString("password", password.editText?.text.toString()).apply()
                result += 1
                null
            }
            return result
        }

        password.editText?.setOnEditorActionListener { _, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    if (validate() == 2) {
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    true
                }
                else -> false
            }
        }
    }
}