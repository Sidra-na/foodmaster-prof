package com.example.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LogInActivity : AppCompatActivity() {
    private lateinit var logInButton:Button
    private lateinit var emailText: EditText
    private lateinit var passwordText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        logInButton=findViewById(R.id.LogInBtn)
        emailText=findViewById(R.id.email_text)
        passwordText=findViewById(R.id.password_text)
        val userEmail=emailText.text
        val userPassword=passwordText.text

        logInButton.setOnClickListener(View.OnClickListener {

            if(userEmail.isEmpty()|| userPassword.isEmpty())
            {
                Toast.makeText(this,"Invalid Data",Toast.LENGTH_LONG).show()
            }
            else
            {
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
            }

        })
    }
}