package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class signIn : AppCompatActivity() {
    companion object{
        const val SHARED_PREFS = "shared_prefs"
        const val EMAIL_KEY = "email_key"
        const val PASSWORD_KEY = "password_key"
    }
    private lateinit var sharedPreferences: SharedPreferences
    private var email: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)

        val emailEdit = findViewById<EditText>(R.id.emailT)
        val passwordEdit = findViewById<EditText>(R.id.passwordT)
        val logBtn = findViewById<Button>(R.id.signBtn)

        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        email = sharedPreferences.getString("EMAIL_KEY", null)
        password = sharedPreferences.getString("PASSWORD_KEY",  null)

        logBtn.setOnClickListener{
            if (TextUtils.isEmpty(emailEdit.text.toString()) && TextUtils.isEmpty(passwordEdit.text.toString())) {
                Toast.makeText(this@signIn, "Please enter email and Password", Toast.LENGTH_SHORT).show()
            } else{
                val editor = sharedPreferences.edit()

                editor.putString(EMAIL_KEY,emailEdit.text.toString())
                editor.putString(PASSWORD_KEY, passwordEdit.text.toString())

                editor.apply()
                 val intent = Intent(this@signIn, nextPage::class.java)
                startActivity(intent)
                finish()
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        if (email !=null && password !=null){
            val intent = Intent(this@signIn, nextPage::class.java)
            startActivity(intent)
        }
    }
}